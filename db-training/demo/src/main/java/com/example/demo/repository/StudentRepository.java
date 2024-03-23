package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.SchoolEntity;
import com.example.demo.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
    @Query(value = "SELECT student FROM StudentEntity student "
            + "JOIN FETCH student.school WHERE student.id = :id")
    Optional<StudentEntity> findStudent(@Param("id") Integer id);

    @Query(value = "SELECT student FROM StudentEntity student " + "JOIN FETCH student.school")
    List<StudentEntity> findAllStudents();
}
