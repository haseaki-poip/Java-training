package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.SchoolEntity;

@Repository
public interface SchoolRepository extends CrudRepository<SchoolEntity, Integer> {
    @Query(value = "SELECT school FROM SchoolEntity school "
            + "JOIN FETCH school.students WHERE school.id = :id")
    Optional<SchoolEntity> findSchool(@Param("id") Integer id);

    @Query(value = "SELECT school FROM SchoolEntity school " + "JOIN FETCH school.students")
    List<SchoolEntity> findAllSchools();
}
