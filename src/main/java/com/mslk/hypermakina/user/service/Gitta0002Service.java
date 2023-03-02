package com.mslk.hypermakina.user.service;

import com.mslk.hypermakina.user.domain.entity.Gitta0002Entity;
import com.mslk.hypermakina.user.domain.repository.Gitta0002Repository;
import com.mslk.hypermakina.user.dto.Gitta0002Dto;
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
public class Gitta0002Service {
    private Gitta0002Repository gitta0002Repository;

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<Gitta0002Dto> getGitta0002list(Integer pageNum) {
        Page<Gitta0002Entity> page = gitta0002Repository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

        List<Gitta0002Entity> gitta0002Entities = page.getContent();
        List<Gitta0002Dto> gitta0002DtoList = new ArrayList<>();

        for (Gitta0002Entity gitta0002Entity : gitta0002Entities) {
            gitta0002DtoList.add(this.convertEntityToDto(gitta0002Entity));
        }

        return gitta0002DtoList;
    }

    @Transactional
    public Long getGitta002Count() {
        return gitta0002Repository.count();
    }

    @Transactional
    public Gitta0002Dto getPost(Long id) {
        Optional<Gitta0002Entity> gitta0001EntityWrapper = gitta0002Repository.findById(id);
        Gitta0002Entity gitta0002Entity = gitta0001EntityWrapper.get();

        return this.convertEntityToDto(gitta0002Entity);
    }

    @Transactional
    public Long savePost(Gitta0002Dto gitta0001Dto) {
        return gitta0002Repository.save(gitta0001Dto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        gitta0002Repository.deleteById(id);
    }

    @Transactional
    public List<Gitta0002Dto> searchPosts(String keyword) {
        List<Gitta0002Entity> gitta0001Entities = gitta0002Repository.findByUsrEnContaining(keyword);
        List<Gitta0002Dto> gitta0002DtoList = new ArrayList<>();

        if (gitta0001Entities.isEmpty()) return gitta0002DtoList;

        for (Gitta0002Entity gitta0002Entity : gitta0001Entities) {
            gitta0002DtoList.add(this.convertEntityToDto(gitta0002Entity));
        }

        return gitta0002DtoList;
    }

    private Gitta0002Dto convertEntityToDto(Gitta0002Entity gitta0002Entity) {
        return Gitta0002Dto.builder()
                .id(gitta0002Entity.getId())
                .usrNm(gitta0002Entity.getUsrNm())
                .usTf(gitta0002Entity.getUsTf())
                .rgEn(gitta0002Entity.getRgEn())
                .usrEn(gitta0002Entity.getUsrEn())
                .ruleId(gitta0002Entity.getRuleId())
                .seTf(gitta0002Entity.getSeTf())
                .altEn(gitta0002Entity.getAltEn())
                .createdDate(gitta0002Entity.getCreatedDate())
                .modifiedDate(gitta0002Entity.getModifiedDate())
                .build();

    }
}
