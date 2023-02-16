package com.mslk.dashboard.service;

import com.mslk.dashboard.domain.entity.DashBoardMngEntity;
import com.mslk.dashboard.domain.repostory.DashBoardMngRepository;
import com.mslk.dashboard.dto.DashBoardMngDto;
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
public class DashBoardMngService {

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    private DashBoardMngRepository dashBoardMngRepository;

    @Transactional
    public List<DashBoardMngDto> getDashBoardMnglist(Integer pageNum) {
        Page<DashBoardMngEntity> page = dashBoardMngRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "id")));

        List<DashBoardMngEntity> dashBoardMngEnties = page.getContent();
        List<DashBoardMngDto> dashBoardMngDtoList = new ArrayList<>();

        for (DashBoardMngEntity dashBoardMngEntity : dashBoardMngEnties) {
            dashBoardMngDtoList.add(this.convertEntityToDto(dashBoardMngEntity));
        }

        return dashBoardMngDtoList;
    }

    @Transactional
    public Long getDashBoardMngCount() {
        return dashBoardMngRepository.count();
    }


    public Integer[] getPageList(Integer curPageNum) {
        // 총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getDashBoardMngCount());

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
    public Long savePost(DashBoardMngDto dashBoardMngDto) {
        return dashBoardMngRepository.save(dashBoardMngDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        dashBoardMngRepository.deleteById(id);
    }


    private DashBoardMngDto convertEntityToDto(DashBoardMngEntity eashBoardMngEntity) {
        return DashBoardMngDto.builder()
                .id(eashBoardMngEntity.getId())
                .dsbType(eashBoardMngEntity.getDsbType())
                .dsbNm(eashBoardMngEntity.getDsbNm())
                .dsbEu(eashBoardMngEntity.getDsbEu())
                .dsbGm(eashBoardMngEntity.getDsbGm())
                .dsbWm(eashBoardMngEntity.getDsbWm())
                .dsbUrl(eashBoardMngEntity.getDsbUrl())
                .seTf(eashBoardMngEntity.getSeTf())
                .dsbNote(eashBoardMngEntity.getDsbNote())
                .altEn(eashBoardMngEntity.getAltEn())
                .createdDate(eashBoardMngEntity.getCreatedDate())
                .modifiedDate(eashBoardMngEntity.getModifiedDate())
                .build();
    }



}
