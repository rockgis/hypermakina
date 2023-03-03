package com.mslk.dashboard.service;

import com.mslk.common.paging.dto.SearchDto;
import com.mslk.dashboard.domain.entity.DashBoardMngEntity;
import com.mslk.dashboard.domain.repostory.DashBoardMngRepository;
import com.mslk.dashboard.dto.DashBoardMngDto;
import com.mslk.sns.department.domain.entity.DepartmentEntity;
import com.mslk.sns.department.dto.DepartmentDto;
import com.mslk.sns.staff.domain.entity.StaffEntity;
import com.mslk.sns.staff.dto.StaffDto;
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


    @Transactional
    public Long savePost(DashBoardMngDto dashBoardMngDto) {
        return dashBoardMngRepository.save(dashBoardMngDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        dashBoardMngRepository.deleteById(id);
    }

    @Transactional
    public DashBoardMngDto getPost(Long id) {
        Optional<DashBoardMngEntity> dashBoardMngEntityWrapper = dashBoardMngRepository.findById(id);
        DashBoardMngEntity dashBoardMngEntity = dashBoardMngEntityWrapper.get();

        return this.convertEntityToDto(dashBoardMngEntity);
    }


    @Transactional
    public List<DashBoardMngDto> searchPosts(SearchDto searchDto) {

        String keyword = searchDto.getKeyword();           // 검색 키워드
        String searchType = searchDto.getSearchType();        // 검색 유형


        List<DashBoardMngEntity> dashBoardMngEntities = null;

        switch (searchType) {
            case "dsbNm":  // dsbNm   이름
                dashBoardMngEntities =  dashBoardMngRepository.findByDsbNmContaining(keyword);
                break;
            case "dsbEu":  // dsbEu 용도
                dashBoardMngEntities =  dashBoardMngRepository.findByDsbEuContaining(keyword);
                break;
            case "dsbWm": // dsbWm  업무명
                dashBoardMngEntities =  dashBoardMngRepository.findByDsbWmContaining(keyword);
                break;
        }

        List<DashBoardMngDto> dashBoardMngList = new ArrayList<>();

        for (DashBoardMngEntity dashBoardMngEntity : dashBoardMngEntities) {
            dashBoardMngList.add(this.convertEntityToDto(dashBoardMngEntity));
        }

        return dashBoardMngList;
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
