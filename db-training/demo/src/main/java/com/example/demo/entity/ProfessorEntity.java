package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "professor")
@Getter
@Setter
public class ProfessorEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    // mappedBy ... ProfessorInfoEntity内のprofessorフィールドからマッピング"される"
    // OneToOneにおける外部キーを管理していない（非所有者）側にmappedByをつける
    // optionalはProfessorEntityがProfessorInfoEntityと関連付けられていない場合があることを意味する
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true,
            mappedBy = "professor")
    private ProfessorInfoEntity professorInfo;
}
