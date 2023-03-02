package com.mslk.sns.syncsvr.service;

import com.mslk.common.paging.dto.SearchDto;
import com.mslk.sns.syncsvr.domain.entity.SyncsvrEntity;
import com.mslk.sns.syncsvr.domain.repository.SyncsvrRepository;
import com.mslk.sns.syncsvr.dto.SyncsvrDto;
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
public class SyncsvrService {

    private SyncsvrRepository syncsvrRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<SyncsvrDto> getSyncsvrlist(Integer pageNum) {
        Page<SyncsvrEntity> page = syncsvrRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

        List<SyncsvrEntity> syncsvrEntities = page.getContent();
        List<SyncsvrDto> syncsvrDtoList = new ArrayList<>();

        for (SyncsvrEntity syncsvrEntity : syncsvrEntities) {
            syncsvrDtoList.add(this.convertEntityToDto(syncsvrEntity));
        }

        return syncsvrDtoList;
    }

    @Transactional
    public Long getSyncsvrCount() {
        return syncsvrRepository.count();
    }

    @Transactional
    public SyncsvrDto getPost(Long id) {
        Optional<SyncsvrEntity> syncsvrEntityWrapper = syncsvrRepository.findById(id);
        SyncsvrEntity syncsvrEntity = syncsvrEntityWrapper.get();

        return this.convertEntityToDto(syncsvrEntity);
    }

    @Transactional
    public Long savePost(SyncsvrDto syncsvrDto) {
        return syncsvrRepository.save(syncsvrDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        syncsvrRepository.deleteById(id);
    }

    @Transactional
    public List<SyncsvrDto> searchPosts(SearchDto searchDto) {

         String keyword = searchDto.getKeyword();           // 검색 키워드
         String searchType = searchDto.getSearchType();        // 검색 유형


        List<SyncsvrEntity> syncsvrEntities = null;

        switch (searchType) {
            case "uid":  // uid   서버 ID
                syncsvrEntities =  syncsvrRepository.findByUidContaining(keyword);
                break;
            case "name":  // 서버명
                syncsvrEntities =  syncsvrRepository.findByNameContaining(keyword);
                break;
            case "ip":  // 서버 IP
                syncsvrEntities =  syncsvrRepository.findByIpContaining(keyword);
                break;

        }

        List<SyncsvrDto> syncsvrDtoList = new ArrayList<>();

        for (SyncsvrEntity syncsvrEntity : syncsvrEntities) {
            syncsvrDtoList.add(this.convertEntityToDto(syncsvrEntity));
        }

        return syncsvrDtoList;
    }

    private SyncsvrDto convertEntityToDto(SyncsvrEntity syncsvrEntity) {
        return SyncsvrDto.builder()
                .id(syncsvrEntity.getId())
                .uid(syncsvrEntity.getUid())
                .name(syncsvrEntity.getName())
                .ip(syncsvrEntity.getIp())
                .seq(syncsvrEntity.getSeq())
                .syncUse(syncsvrEntity.getSyncUse())
                .del(syncsvrEntity.getDel())
                .memo(syncsvrEntity.getMemo())
                .createdDate(syncsvrEntity.getCreatedDate())
                .modifiedDate(syncsvrEntity.getModifiedDate())
                .deleteDate(syncsvrEntity.getDeleteDate())
                .build();
    }
}
