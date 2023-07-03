package com.example.demo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Repository
public interface HumanRepo extends JpaRepository<Human, BigInteger>  {

    @NonNull
    @EntityGraph(attributePaths = {
            "houses.address",
    })
    @Query("SELECT h FROM Human h WHERE h.id IN ?1")
    Human findByIdHousesEagerlyByEntityGraph(BigInteger id);

    @Query("SELECT DISTINCT human " +
            "FROM Human human " +
            "LEFT OUTER JOIN FETCH human.houses houses " +
            "LEFT OUTER JOIN FETCH houses.address " +  //different from findByIdHousesEagerlyByQueryWithJoinOn
            "WHERE human.id IN ?1")
    Human findByIdHousesEagerlyByQuery(BigInteger id);

    @Query("SELECT DISTINCT human " +
            "FROM Human human " +
            "LEFT OUTER JOIN FETCH human.houses houses " +
            "LEFT OUTER JOIN FETCH Address a on a.id = houses.address.id " + //different from findByIdHousesEagerlyByQuery
            "WHERE human.id IN ?1")
    Human findByIdHousesEagerlyByQueryWithJoinOn(BigInteger id);
}
