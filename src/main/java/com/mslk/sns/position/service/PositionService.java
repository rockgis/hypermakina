package com.mslk.sns.position.service;

import com.mslk.common.paging.dto.SearchDto;
import com.mslk.sns.position.domain.entity.PositionEntity;
import com.mslk.sns.position.domain.repository.PositionRepository;
import com.mslk.sns.position.dto.PositionDto;
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
public class PositionService {

    private PositionRepository positionRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<PositionDto> getPositionlist(Integer pageNum) {
        Page<PositionEntity> page = positionRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

        List<PositionEntity> positionEntities = page.getContent();
        List<PositionDto> positionDtotoList = new ArrayList<>();

        for (PositionEntity positionEntity : positionEntities) {
            positionDtotoList.add(this.convertEntityToDto(positionEntity));
        }

        return positionDtotoList;
    }

    @Transactional
    public Long getPositionCount() {
        return positionRepository.count();
    }

    @Transactional
    public PositionDto getPost(Long id) {
        Optional<PositionEntity> PositionEntityWrapper = positionRepository.findById(id);
        PositionEntity PositionEntity = PositionEntityWrapper.get();

        return this.convertEntityToDto(PositionEntity);
    }

    @Transactional
    public Long savePost(PositionDto positionDto) {
        return positionRepository.save(positionDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        positionRepository.deleteById(id);
    }


    @Transactional
     public List<PositionDto> searchPosts(SearchDto searchDto) {

         String keyword = searchDto.getKeyword();           // 검색 키워드
         String searchType = searchDto.getSearchType();        // 검색 유형


        List<PositionEntity> positionEntities = null;

        switch (searchType) {
            case "uid":  // uid   부서 아이디
                positionEntities =  positionRepository.findByUidContaining(keyword);
                break;
            case "name":  // 부서 이름
                positionEntities =  positionRepository.findByNameContaining(keyword);
                break;

        }

        List<PositionDto> positionList = new ArrayList<>();

        for (PositionEntity positionEntity : positionEntities) {
            positionList.add(this.convertEntityToDto(positionEntity));
        }

        return positionList;
    }



    private PositionDto convertEntityToDto(PositionEntity positionEntity) {
        return PositionDto.builder()
                .id(positionEntity.getId())
                .uid(positionEntity.getUid())
                .name(positionEntity.getName())
                .seq(positionEntity.getSeq())
                .syncUse(positionEntity.getSyncUse())
                .del(positionEntity.getDel())
                .memo(positionEntity.getMemo())
                .createdDate(positionEntity.getCreatedDate())
                .modifiedDate(positionEntity.getModifiedDate())
                .deleteDate(positionEntity.getDeleteDate())
                .build();
    }
}
