package com.mslk.restapi.service;

import com.mslk.restapi.domain.entity.HyperRestApiEntity;
import com.mslk.restapi.domain.repostory.HyperrestapiRepository;
import com.mslk.restapi.dto.HyperRestApiDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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


    public Integer[] getPageList(Integer curPageNum) {
        // 총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getHyperRestApiCount());

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
    public Long savePost(HyperRestApiDto hyperRestApiDto) {
        return hyperrestapiRepository.save(hyperRestApiDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        hyperrestapiRepository.deleteById(id);
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
