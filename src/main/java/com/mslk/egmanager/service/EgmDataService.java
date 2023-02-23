package com.mslk.egmanager.service;

import com.mslk.egmanager.domain.entity.EgmDataEntity;
import com.mslk.egmanager.domain.repostory.EgmDataRepository;
import com.mslk.egmanager.dto.EgmDataDto;
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
public class EgmDataService {

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    private EgmDataRepository egmDataRepository;

    @Transactional
    public List<EgmDataDto> getEgmDatalist(Integer pageNum) {
        Page<EgmDataEntity> page = egmDataRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "id")));

        List<EgmDataEntity> EgmDataEnties = page.getContent();
        List<EgmDataDto> EgmDataDtoList = new ArrayList<>();

        for (EgmDataEntity EgmDataEntity : EgmDataEnties) {
            EgmDataDtoList.add(this.convertEntityToDto(EgmDataEntity));
        }

        return EgmDataDtoList;
    }

    @Transactional
    public Long getEgmDataCount() {
        return egmDataRepository.count();
    }


    public Integer[] getPageList(Integer curPageNum, Double postsTotalCount) {
        // 총 게시글 갯수
       // Double postsTotalCount = Double.valueOf(this.getEgmDataCount());

        // 총 게시글 기준으로 계산한 마지막 페이지 번호 계산
        Integer totalLastPageNum = (int)(Math.ceil((postsTotalCount/PAGE_POST_COUNT)));

        // 현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
        Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
                ? curPageNum + BLOCK_PAGE_NUM_COUNT
                : totalLastPageNum;

        Integer[] pageList = new Integer[blockLastPageNum];

        // 페이지 시작 번호 조정
        curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

        // 페이지 번호 할당
        for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
            pageList[idx] = val;
        }

        return pageList;
    }


    @Transactional
    public Long savePost(EgmDataDto egmDataDto) {
        return egmDataRepository.save(egmDataDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        egmDataRepository.deleteById(id);
    }


    @Transactional
    public EgmDataDto getPost(Long id) {
        Optional<EgmDataEntity> egmDataEntityyWrapper = egmDataRepository.findById(id);
        EgmDataEntity egmDataEntity = egmDataEntityyWrapper.get();

        return this.convertEntityToDto(egmDataEntity);
    }

    private EgmDataDto convertEntityToDto(EgmDataEntity egmDataEntity) {
        return EgmDataDto.builder()
                .id(egmDataEntity.getId())
                .metaId(egmDataEntity.getMetaId())
                .restName(egmDataEntity.getRestName())
                .componentName(egmDataEntity.getComponentName())
                .startDate(egmDataEntity.getStartDate())
                .endDate(egmDataEntity.getEndDate())
                .test(egmDataEntity.getTest())
                .info(egmDataEntity.getInfo())
                .componentType(egmDataEntity.getComponentType())
                .timeline(egmDataEntity.getTimeline())
                .measure(egmDataEntity.getMeasure())
                .seTf(egmDataEntity.getSeTf())
                .altEn(egmDataEntity.getAltEn())
                .createdDate(egmDataEntity.getCreatedDate())
                .modifiedDate(egmDataEntity.getModifiedDate())
                .build();
    }

}
