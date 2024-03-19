package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.ProfessorInfoEntity;

@Repository
public interface ProfessorInfoRepository extends CrudRepository<ProfessorInfoEntity, Integer> {

}
