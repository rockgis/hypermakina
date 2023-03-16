package com.mslk.restapi.service;

import com.mslk.restapi.domain.entity.HyperRestApiEntity;
import com.mslk.restapi.domain.repostory.HyperrestapiRepository;
import com.mslk.restapi.dto.HyperRestApiDto;
import com.mslk.sns.department.domain.entity.DepartmentEntity;
import com.mslk.sns.department.dto.DepartmentDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HyperRestApiService {

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수
    private HyperrestapiRepository hyperrestapiRepository;

    @Transactional
    public List<HyperRestApiDto> getHyperRestlist(Integer pageNum) {
        Page<HyperRestApiEntity> page = hyperrestapiRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

        List<HyperRestApiEntity> hyperRestApiEnties = page.getContent();
        List<HyperRestApiDto> hyperRestApiDtoList = new ArrayList<>();

        for (HyperRestApiEntity hyperRestApiEntity : hyperRestApiEnties) {
            hyperRestApiDtoList.add(this.convertEntityToDto(hyperRestApiEntity));
        }

        return hyperRestApiDtoList;
    }

    @Transactional
    public Long getHyperRestApiCount() {
        return hyperrestapiRepository.count();
    }



    @Transactional
    public Long savePost(HyperRestApiDto hyperRestApiDto) {
        return hyperrestapiRepository.save(hyperRestApiDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        hyperrestapiRepository.deleteById(id);
    }

    @Transactional
    public HyperRestApiDto getPost(String restFunction) {
        Optional<HyperRestApiEntity> hyperRestApiEntityWrapper = hyperrestapiRepository.findByRestFunction(restFunction);
        HyperRestApiEntity hyperRestApiEntity = hyperRestApiEntityWrapper.get();

        return this.convertEntityToDto(hyperRestApiEntity);
    }


    private HyperRestApiDto convertEntityToDto(HyperRestApiEntity hyperRestApiEntity) {
        return HyperRestApiDto.builder()
                .id(hyperRestApiEntity.getId())
                .restType(hyperRestApiEntity.getRestType())
                .restContent(hyperRestApiEntity.getRestContent())
                .usrEn(hyperRestApiEntity.getUsrEn())
                .usrPw(hyperRestApiEntity.getUsrPw())
                .managerurl(hyperRestApiEntity.getManagerurl())
                .egmmngid(hyperRestApiEntity.getEgmmngid())
                .restServer(hyperRestApiEntity.getRestServer())
                .restFunction(hyperRestApiEntity.getRestFunction())
                .restHttp(hyperRestApiEntity.getRestHttp())
                .seTf(hyperRestApiEntity.getSeTf())
                .restSync(hyperRestApiEntity.getRestSync())
                .syncTime(hyperRestApiEntity.getSyncTime())
                .altEn(hyperRestApiEntity.getAltEn())
                .createdDate(hyperRestApiEntity.getCreatedDate())
                .modifiedDate(hyperRestApiEntity.getModifiedDate())
                .build();
    }
}
