package com.example.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "professor_info")
@Setter
@Getter
public class ProfessorInfoEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "gender")
    private String gender;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // 外部キーprofessor_idを設定
    // nullableのためProfessorInfoEntityインスタンスがProfessorEntityインスタンスに関連付けられていない場合があることを意味する
    @JoinColumn(name = "professor_id", unique = true, nullable = true, updatable = true)
    private ProfessorEntity professor;
}
