package com.mslk.sns.sms.service;

import com.mslk.common.paging.dto.SearchDto;
import com.mslk.sns.department.domain.entity.DepartmentEntity;
import com.mslk.sns.department.dto.DepartmentDto;
import com.mslk.sns.sms.domain.entity.MmsEntity;
import com.mslk.sns.sms.dto.LguMmsDto;
import com.mslk.sns.sms.domain.repository.MmsRepository;
import com.mslk.sns.sms.dto.MmsDto;
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
public class MmsService {

    private MmsRepository mmsRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<MmsDto> getMmslist(Integer pageNum) {
        Page<MmsEntity> page = mmsRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "id")));

        List<MmsEntity> mmsEntities = page.getContent();
        List<MmsDto> MmsDtotoList = new ArrayList<>();

        for (MmsEntity mmsEntity : mmsEntities) {
            MmsDtotoList.add(this.convertEntityToDto(mmsEntity));
        }

        return MmsDtotoList;
    }

    @Transactional
    public List<MmsDto> getMmslistAll() {

        List<MmsEntity> mmsEntities = mmsRepository.findAll( Sort.by(Sort.Direction.DESC, "id"));
        List<MmsDto> mmsDtotoList = new ArrayList<>();

        for (MmsEntity mmsEntity : mmsEntities) {
            mmsDtotoList.add(this.convertEntityToDto(mmsEntity));
        }

        return mmsDtotoList;
    }

    @Transactional
    public Long getMmsCount() {
        return mmsRepository.count();
    }

    @Transactional
    public MmsDto getPost(Long id) {
        Optional<MmsEntity> mmsEntityWrapper = mmsRepository.findById(id);
        MmsEntity mmsEntity = mmsEntityWrapper.get();

        return this.convertEntityToDto(mmsEntity);
    }


    @Transactional
    public MmsDto getTypePost(String type) {
        Optional<MmsEntity> mmsEntityWrapper = mmsRepository.findByType(type);
        MmsEntity mmsEntity = mmsEntityWrapper.get();

        return this.convertEntityToDto(mmsEntity);
    }

    @Transactional
    public String savePost(MmsDto mmsDto) {
        return mmsRepository.save(mmsDto.toEntity()).getStatus();
    }

    @Transactional
    public void deletePost(Long id) {
        mmsRepository.deleteById(id);
    }

    @Transactional
    public List<MmsDto> searchPosts(SearchDto searchDto) {

        String keyword = searchDto.getKeyword();           // 검색 키워드
        String searchType = searchDto.getSearchType();        // 검색 유형


        List<MmsEntity> mmsEntities = null;

        switch (searchType) {
            case "uid":  // uid   부서 아이디
               // MmsEntities =  MmsRepository.findByUidContaining(keyword);
                break;
            case "name":  // 부서 이름
              //  MmsEntities =  MmsRepository.findByNameContaining(keyword);
                break;

        }

        List<MmsDto> mmsList = new ArrayList<>();

        for (MmsEntity mmsEntity : mmsEntities) {
            mmsList.add(this.convertEntityToDto(mmsEntity));
        }

        return mmsList;
    }





    private MmsDto convertEntityToDto(MmsEntity mmsEntity) {
        return MmsDto.builder()
                .id(mmsEntity.getId())
                .codemng_id(mmsEntity.getCodemng_id())
                .subject(mmsEntity.getSubject())
                .subject(mmsEntity.getSubject())
                .phone(mmsEntity.getPhone())
                .callback(mmsEntity.getCallback())
                .status(mmsEntity.getStatus())
                .msg(mmsEntity.getMsg())
                .type(mmsEntity.getType())
                .memo(mmsEntity.getMemo())
                .build();
    }

}
