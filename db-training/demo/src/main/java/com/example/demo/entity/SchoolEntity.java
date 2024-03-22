package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "school")
public class SchoolEntity implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    // mappedBy ... StudentEntity内のschoolフィールドからマッピング"される"
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "school")
    private Set<StudentEntity> students = new HashSet<>();
    // 初期値としてnew HashSetをしておくこどで該当するデータが存在しなかった場合、set型のこのフィールドがnullにならないようにしてある
    // もともとSetもしくはlistで複数のデータを想定している場合、何もなかった場合はnullではなく[]といった空の配列や空のSetが来る方が自然
}
