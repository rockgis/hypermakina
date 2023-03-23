package com.mslk.sns.concurrent.service;

import com.mslk.common.paging.dto.SearchDto;
import com.mslk.sns.concurrent.domain.entity.ConcurrentEntity;
import com.mslk.sns.concurrent.domain.repository.ConcurrentRepository;
import com.mslk.sns.concurrent.dto.ConcurrentDto;
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
public class ConcurrentService {

    private ConcurrentRepository concurrentRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<ConcurrentDto> getConcurrentlist(Integer pageNum) {
        Page<ConcurrentEntity> page = concurrentRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

        List<ConcurrentEntity> concurrentEntities = page.getContent();
        List<ConcurrentDto> concurrentDtotoList = new ArrayList<>();

        for (ConcurrentEntity concurrentEntity : concurrentEntities) {
            concurrentDtotoList.add(this.convertEntityToDto(concurrentEntity));
        }

        return concurrentDtotoList;
    }

    @Transactional
    public Long getConcurrentCount() {
        return concurrentRepository.count();
    }

    @Transactional
    public ConcurrentDto getPost(Long id) {
        Optional<ConcurrentEntity> concurrentEntityWrapper = concurrentRepository.findById(id);
        ConcurrentEntity concurrentEntity = concurrentEntityWrapper.get();

        return this.convertEntityToDto(concurrentEntity);
    }

    @Transactional
    public Long savePost(ConcurrentDto concurrentDto) {
        return concurrentRepository.save(concurrentDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        concurrentRepository.deleteById(id);
    }

    @Transactional
    public List<ConcurrentDto> searchPosts(SearchDto searchDto) {

         String keyword = searchDto.getKeyword();           // 검색 키워드
         String searchType = searchDto.getSearchType();        // 검색 유형


        List<ConcurrentEntity> concurrentEntities = null;

       /* switch (searchType) {
            case "uid":  // uid   아이디
                concurrentEntities =  concurrentRepository.findByUidContaining(keyword);
                break;
            case "fullName":  // fullName 이름
                concurrentEntities =  concurrentRepository.findByFullNameContaining(keyword);
                break;
            case "identityNo": // identityNo  사원번호
                concurrentEntities =  concurrentRepository.findByIdentityNoContaining(keyword);
                break;
            case "eMail":  // eMail 이메일
                concurrentEntities =  concurrentRepository.findByeMailContaining(keyword);
                break;
            case "hp":  // hp 헨드폰 번호
                concurrentEntities =  concurrentRepository.findByHpContaining(keyword);
                break;
        }*/

        List<ConcurrentDto> concurrentDtotoList = new ArrayList<>();

        for (ConcurrentEntity concurrentEntity : concurrentEntities) {
            concurrentDtotoList.add(this.convertEntityToDto(concurrentEntity));
        }

        return concurrentDtotoList;
    }

    private ConcurrentDto convertEntityToDto(ConcurrentEntity concurrentEntity) {
        return com.mslk.sns.concurrent.dto.ConcurrentDto.builder()
                .id(concurrentEntity.getId())
                .uid(concurrentEntity.getUid())
                .name(concurrentEntity.getName())
                .rankId(concurrentEntity.getRankId())
                .positionId(concurrentEntity.getPositionId())
                .departmentId(concurrentEntity.getDepartmentId())
                .head(concurrentEntity.getHead())
                .seq(concurrentEntity.getSeq())
                .syncUse(concurrentEntity.getSyncUse())
                .del(concurrentEntity.getDel())
                .memo(concurrentEntity.getMemo())
                .createdDate(concurrentEntity.getCreatedDate())
                .modifiedDate(concurrentEntity.getModifiedDate())
                .deleteDate(concurrentEntity.getDeleteDate())
                .build();
    }
}
