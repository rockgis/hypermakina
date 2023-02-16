package com.mslk.hypermakina.code.service;

import com.mslk.hypermakina.code.domain.entity.CodeMngEntity;
import com.mslk.hypermakina.code.domain.repostory.CodeMngRepository;
import com.mslk.hypermakina.code.dto.CodeMngDto;
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
public class CodeMngService {

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    private CodeMngRepository codeMngRepository;

    @Transactional
    public List<CodeMngDto> getCodeMnglist(Integer pageNum) {
        Page<CodeMngEntity> page = codeMngRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "id")));

        List<CodeMngEntity> codeMngEnties = page.getContent();
        List<CodeMngDto> dashBoardMngDtoList = new ArrayList<>();

        for (CodeMngEntity codeMngMngEntity : codeMngEnties) {
            dashBoardMngDtoList.add(this.convertEntityToDto(codeMngMngEntity));
        }

        return dashBoardMngDtoList;
    }

    @Transactional
    public Long getCodeMngCount() {
        return codeMngRepository.count();
    }


    public Integer[] getPageList(Integer curPageNum) {
        // 총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getCodeMngCount());

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
    public Long savePost(CodeMngDto codeMngDto) {
        return codeMngRepository.save(codeMngDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        codeMngRepository.deleteById(id);
    }


    private CodeMngDto convertEntityToDto(CodeMngEntity codeMngEntity) {
        return CodeMngDto.builder()
                .id(codeMngEntity.getId())
                .codeType(codeMngEntity.getCodeType())
                .codeEu(codeMngEntity.getCodeEu())
                .codeGm(codeMngEntity.getCodeGm())
                .codeWm(codeMngEntity.getCodeWm())
                .codeNm(codeMngEntity.getCodeNm())
                .codeVm(codeMngEntity.getCodeVm())
                .codeNote(codeMngEntity.getCodeNote())
                .seTf(codeMngEntity.getSeTf())
                .altEn(codeMngEntity.getAltEn())
                .createdDate(codeMngEntity.getCreatedDate())
                .modifiedDate(codeMngEntity.getModifiedDate())
                .build();
    }
}
