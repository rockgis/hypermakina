package com.mslk.hypermakina.logmng.service;

import com.mslk.hypermakina.logmng.domain.repository.Gitte0001Repository;
import com.mslk.hypermakina.logmng.domain.entity.Gitte0001Entity;
import com.mslk.hypermakina.logmng.dto.Gitte0001Dto;
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
public class Gitte0001Service {
    private Gitte0001Repository gitte0001Repository;

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<Gitte0001Dto> getGitte0001list(Integer pageNum) {
        Page<Gitte0001Entity> page = gitte0001Repository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

        List<Gitte0001Entity> gittf0001Entities = page.getContent();
        List<Gitte0001Dto> gitte0001DtoList = new ArrayList<>();

        for (Gitte0001Entity gitte0001Entity : gittf0001Entities) {
            gitte0001DtoList.add(this.convertEntityToDto(gitte0001Entity));
        }

        return gitte0001DtoList;
    }

    @Transactional
    public Long getGitte001Count() {
        return gitte0001Repository.count();
    }

    @Transactional
    public Gitte0001Dto getPost(Long id) {
        Optional<Gitte0001Entity> gittf0001EntityWrapper = gitte0001Repository.findById(id);
        Gitte0001Entity gitte0001Entity = gittf0001EntityWrapper.get();

        return this.convertEntityToDto(gitte0001Entity);
    }

    @Transactional
    public Long savePost(Gitte0001Dto gitte0001Dto) {
        return gitte0001Repository.save(gitte0001Dto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        gitte0001Repository.deleteById(id);
    }

    @Transactional
    public List<Gitte0001Dto> searchPosts(String keyword) {
        List<Gitte0001Entity> gittf0001Entities = gitte0001Repository.findByUsrNmContaining(keyword);
        List<Gitte0001Dto> gitte0001DtoList = new ArrayList<>();

        if (gittf0001Entities.isEmpty()) return gitte0001DtoList;

        for (Gitte0001Entity gitte0001Entity : gittf0001Entities) {
            gitte0001DtoList.add(this.convertEntityToDto(gitte0001Entity));
        }

        return gitte0001DtoList;
    }

    private Gitte0001Dto convertEntityToDto(Gitte0001Entity gitte0001Entity) {
        return Gitte0001Dto.builder()
                .id(gitte0001Entity.getId())
                .dcd(gitte0001Entity.getDcd())
                .usrNm(gitte0001Entity.getUsrNm())
                .usrEn(gitte0001Entity.getUsrEn())
                .reqNm(gitte0001Entity.getReqNm())
                .mnuId(gitte0001Entity.getMnuId())
                .createdDate(gitte0001Entity.getCreatedDate())
                .build();

        // this.rg_dt = rg_dt;
        // this.alt_dt = alt_dt;
    }
}
