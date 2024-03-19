package com.example.demo.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.controller.request.ProfessorRequest;
import com.example.demo.controller.response.ProfessorResponse;
import com.example.demo.entity.ProfessorEntity;
import com.example.demo.entity.ProfessorInfoEntity;
import com.example.demo.repository.ProfessorInfoRepository;
import com.example.demo.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor // fainalや@NonNullがついてフィールドに対するコンストラクタが自動で生成される
public class ProfessorService {
    // @RequiredArgsConstructorによってコンストラクタが作成され、単一のコンストラクタは、@Autowiredをつけなくとも良いことになっている
    private final ProfessorRepository professorRepo;
    private final ProfessorInfoRepository professorInfoRepo;
    private final ModelMapper modelMapper;

    // 複数のフィールドに対するAutowiredは以下のようにコンストラクタにAutowiredをつける
    // ただしコンストラクタ一つのため@Autowiredは省略可能
    // @RequiredArgsConstructorをつけていればこのコンストラクタの記述も勝手生成してくれる
    // @Autowired
    // public ProfessorService(ProfessorRepository professorRepo,
    // ProfessorInfoRepository professorInfoRepo, ModelMapper modelMapper) {
    // this.professorRepo = professorRepo;
    // this.professorInfoRepo = professorInfoRepo;
    // this.modelMapper = modelMapper;
    // }


    @Transactional // データの登録処理のトランザクション。全てが完了する前に障害が起きると全ての処理をロールバック
    public void create(ProfessorRequest request) {
        ProfessorEntity requestEntity = modelMapper.map(request, ProfessorEntity.class);
        // save Professor
        ProfessorEntity savedProfessorEntity = professorRepo.save(requestEntity);
        // save ProfessorInfo
        ProfessorInfoEntity professorInfoEntity = requestEntity.getProfessorInfo();
        professorInfoEntity.setProfessor(savedProfessorEntity);
        professorInfoRepo.save(professorInfoEntity);
    }

    @Transactional
    public void update(String id, ProfessorRequest request) {
        ProfessorEntity targeEntity = professorRepo.findProfessor(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("NOT FOUND Professor"));
        // update professor and professorInfo
        // targeEntityはRepositoryにのメソッド(標準のメソッド、Queryによって作成したメソッド)により取得しているため永続化コンテキスト（JPAの管理下)であり
        // 特別save処理などを書かなくても以下のようにtargeEntityの中身を変えるだけで変更される(例: targeEntity.setName("hoge");)
        modelMapper.map(request, targeEntity);
    }

    public ProfessorResponse findProfessor(String id) {
        ProfessorEntity professorEntity = professorRepo.findProfessor(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("NOT FOUND Professor"));
        return modelMapper.map(professorEntity, ProfessorResponse.class);
    }

    public List<ProfessorResponse> findAllProfessors() {
        List<ProfessorEntity> professorEntities = professorRepo.findAllProfessors();
        return modelMapper.map(professorEntities,
                new TypeToken<List<ProfessorResponse>>() {}.getType());
    }


}
