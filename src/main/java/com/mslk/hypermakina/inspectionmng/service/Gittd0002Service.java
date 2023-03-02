package com.mslk.hypermakina.inspectionmng.service;

import com.mslk.hypermakina.inspectionmng.domain.entity.Gittd0002Entity;
import com.mslk.hypermakina.inspectionmng.domain.repository.Gittd0002Repository;
import com.mslk.hypermakina.inspectionmng.dto.Gittd0002Dto;
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
public class Gittd0002Service {
    private Gittd0002Repository gittd0002Repository;

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<Gittd0002Dto> getGittd0002list(Integer pageNum) {
        Page<Gittd0002Entity> page = gittd0002Repository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

        List<Gittd0002Entity> gitta0002Entities = page.getContent();
        List<Gittd0002Dto> gittd0002DtoList = new ArrayList<>();

        for (Gittd0002Entity gittd0002Entity : gitta0002Entities) {
            gittd0002DtoList.add(this.convertEntityToDto(gittd0002Entity));
        }

        return gittd0002DtoList;
    }

    @Transactional
    public Long getGittd002Count() {
        return gittd0002Repository.count();
    }

    @Transactional
    public Gittd0002Dto getPost(Long id) {
        Optional<Gittd0002Entity> gitta0002EntityWrapper = gittd0002Repository.findById(id);
        Gittd0002Entity gittd0002Entity = gitta0002EntityWrapper.get();

        return this.convertEntityToDto(gittd0002Entity);
    }

    @Transactional
    public Long savePost(Gittd0002Dto gittd0001Dto) {
        return gittd0002Repository.save(gittd0001Dto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        gittd0002Repository.deleteById(id);
    }

    @Transactional
    public List<Gittd0002Dto> searchPosts(String keyword) {

        List<Gittd0002Entity> gitta0002Entities = gittd0002Repository.findByUsrEnContaining(keyword);
        List<Gittd0002Dto> gittd0002DtoList = new ArrayList<>();

        if (gitta0002Entities.isEmpty()) return gittd0002DtoList;

        for (Gittd0002Entity gittd0002Entity : gitta0002Entities) {
            gittd0002DtoList.add(this.convertEntityToDto(gittd0002Entity));
        }

        return gittd0002DtoList;
    }


    private Gittd0002Dto convertEntityToDto(Gittd0002Entity gittd0002Entity) {
        return Gittd0002Dto.builder()
                .id(gittd0002Entity.getId())
                .ugNm(gittd0002Entity.getUgNm())
                .dcd(gittd0002Entity.getDcd())
                .usrNm(gittd0002Entity.getUsrNm())
                .usrEn(gittd0002Entity.getUsrEn())
                .emNm(gittd0002Entity.getEmNm())
                .ugId(gittd0002Entity.getUgId())
                .usrIp(gittd0002Entity.getUsrIp())
                .lfDt(gittd0002Entity.getLfDt())
                .createdDate(gittd0002Entity.getCreatedDate())
                .build();
    }
}
