package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.ProfessorEntity;

@Repository
// 単純なCRUD操作のみが必要な場合はCrudRepositoryのインターフェースを使用。より高度な場合はJpaRepositoryなど
public interface ProfessorRepository extends CrudRepository<ProfessorEntity, Integer> {
    @Query(value = "SELECT DISTINCT professor FROM ProfessorEntity professor "
            + "JOIN FETCH professor.professorInfo WHERE professor.id = :id")
    // 可読性を高めるためにプラスを使用して二行にしている
    public Optional<ProfessorEntity> findProfessor(@Param("id") Integer id);

    @Query(value = "SELECT DISTINCT professor FROM ProfessorEntity professor "
            + "JOIN FETCH professor.professorInfo")
    public List<ProfessorEntity> findAllProfessors();
}
