package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    HumanRepo repo;

    @Test
    void shouldReturnAlwaysSameNumberOfHuman() {
        //given
        Human human = new Human();

        //when
        repo.save(human);

        Human human1 = repo.findByIdHousesEagerlyByQueryWithJoinOn(human.getId());
        Human human2 = repo.findByIdHousesEagerlyByEntityGraph(human.getId());
        Human human3 = repo.findByIdHousesEagerlyByQuery(human.getId());

        //then
        assertNotNull(human1);
        assertNotNull(human2);
        assertNotNull(human3);
    }
}
