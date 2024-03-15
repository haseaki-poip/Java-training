package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT DISTINCT user FROM User user WHERE user.name LIKE name")
    List<User> findByName(@Param("name") String name);

    // 上記のようにJPQLによってQueryを設定しなくても以下のような記述でいける
    // nameで探索する時はfindByの後にname(プロパティ名)の最初の文字を大文字にするルール
    // List<User> findByName(String name);

    Optional<User> findById(Long id);
}
