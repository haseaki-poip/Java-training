package com.example.demo.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 引数ありのとき、自動的に書くフィールでへ引数を割り当てるコンストラクタを生成
@NoArgsConstructor // 引数なしのとき、自動的に引数を取らないデフォルトコンストラクタを生成
@Data
public class ProfessorInfoRequest {
    private String birthDate;
    private String gender;
}
