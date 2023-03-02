package com.mslk.sns.rank.service;

import com.mslk.sns.rank.domain.entity.RankEntity;
import com.mslk.sns.rank.domain.repository.RankRepository;
import com.mslk.sns.rank.dto.RankDto;
import com.mslk.common.paging.dto.SearchDto;
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
public class RankService {

    private RankRepository rankRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<RankDto> getRanklist(Integer pageNum) {
        Page<RankEntity> page = rankRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

        List<RankEntity> rankEntities = page.getContent();
        List<RankDto> rankDtoList = new ArrayList<>();

        for (RankEntity rankEntity : rankEntities) {
            rankDtoList.add(this.convertEntityToDto(rankEntity));
        }

        return rankDtoList;
    }

    @Transactional
    public Long getRankCount() {
        return rankRepository.count();
    }

    @Transactional
    public RankDto getPost(Long id) {
        Optional<RankEntity> rankEntityWrapper = rankRepository.findById(id);
        RankEntity rankEntity = rankEntityWrapper.get();

        return this.convertEntityToDto(rankEntity);
    }

    @Transactional
    public Long savePost(RankDto RankDto) {
        return rankRepository.save(RankDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        rankRepository.deleteById(id);
    }

    @Transactional
     public List<RankDto> searchPosts(SearchDto searchDto) {

         String keyword = searchDto.getKeyword();           // 검색 키워드
         String searchType = searchDto.getSearchType();        // 검색 유형


        List<RankEntity> rankEntities = null;

        switch (searchType) {
            case "uid":  // uid   부서 아이디
                rankEntities =  rankRepository.findByUidContaining(keyword);
                break;
            case "name":  // 부서 이름
                rankEntities =  rankRepository.findByNameContaining(keyword);
                break;

        }

        List<RankDto> rankDtoList = new ArrayList<>();

        for (RankEntity rankEntity : rankEntities) {
            rankDtoList.add(this.convertEntityToDto(rankEntity));
        }

        return rankDtoList;
    }


    private RankDto convertEntityToDto(RankEntity rankEntity) {
        return RankDto.builder()
                .id(rankEntity.getId())
                .uid(rankEntity.getUid())
                .name(rankEntity.getName())
                .seq(rankEntity.getSeq())
                .syncUse(rankEntity.getSyncUse())
                .del(rankEntity.getDel())
                .memo(rankEntity.getMemo())
                .createdDate(rankEntity.getCreatedDate())
                .modifiedDate(rankEntity.getModifiedDate())
                .deleteDate(rankEntity.getDeleteDate())
                .build();
    }
}
