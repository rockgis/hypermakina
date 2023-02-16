package com.mslk.egmanager.service;

import com.mslk.egmanager.domain.entity.EgmMetaEntity;
import com.mslk.egmanager.domain.repostory.EgmMetaRepository;
import com.mslk.egmanager.dto.EgmMetaDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Service
public class EgmMetaService {

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    private EgmMetaRepository egmMetaRepository;

    @Transactional
    public List<EgmMetaDto> getEgmMetalist(Integer pageNum) {
        Page<EgmMetaEntity> page = egmMetaRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "id")));

        List<EgmMetaEntity> EgmMetaEnties = page.getContent();
        List<EgmMetaDto> EgmMetaDtoList = new ArrayList<>();

        for (EgmMetaEntity EgmMetaEntity : EgmMetaEnties) {
            EgmMetaDtoList.add(this.convertEntityToDto(EgmMetaEntity));
        }

        return EgmMetaDtoList;
    }

    @Transactional
    public Long getEgmMetaCount() {
        return egmMetaRepository.count();
    }


    public Integer[] getPageList(Integer curPageNum) {
        // 총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getEgmMetaCount());

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
    public Long savePost(EgmMetaDto EgmMetaDto) {
        return egmMetaRepository.save(EgmMetaDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        egmMetaRepository.deleteById(id);
    }


    private EgmMetaDto convertEntityToDto(EgmMetaEntity egmMetaEntity) {
        return EgmMetaDto.builder()
                .id(egmMetaEntity.getId())
                .metaType(egmMetaEntity.getMetaType())
                .metaNm((egmMetaEntity.getMetaNm()))
                .metaEu(egmMetaEntity.getMetaEu())
                .metaMm(egmMetaEntity.getMetaMm())
                .metaGm(egmMetaEntity.getMetaGm())
                .metaWm(egmMetaEntity.getMetaWm())
                .metaHm(egmMetaEntity.getMetaHm())
                .metaOs(egmMetaEntity.getMetaOs())
                .metaIp(egmMetaEntity.getMetaIp())
                .metaTm(egmMetaEntity.getMetaTm())
                .metaNote(egmMetaEntity.getMetaNote())
                .altEn(egmMetaEntity.getAltEn())
                .createdDate(egmMetaEntity.getCreatedDate())
                .modifiedDate(egmMetaEntity.getModifiedDate())
                .build();
    }

}
