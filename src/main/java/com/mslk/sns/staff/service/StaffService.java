package com.mslk.sns.staff.service;

import com.mslk.sns.staff.domain.entity.StaffEntity;
import com.mslk.sns.staff.domain.repository.StaffRepository;
import com.mslk.sns.staff.dto.StaffDto;
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
public class StaffService {

    private StaffRepository staffRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<StaffDto> getStafflist(Integer pageNum) {
        Page<StaffEntity> page = staffRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

        List<StaffEntity> staffEntities = page.getContent();
        List<StaffDto> staffDtotoList = new ArrayList<>();

        for (StaffEntity staffEntity : staffEntities) {
            staffDtotoList.add(this.convertEntityToDto(staffEntity));
        }

        return staffDtotoList;
    }

    @Transactional
    public int getStaffCountUid(String uid, String check) {

        int result = 0;

        switch (check) {
            case "uid":  // uid   아이디
                result = staffRepository.findUidCount(uid);
                break;
            case "identityNo": // identityNo  사원번호
                result = staffRepository.findIdentityNoCount(uid);
                break;
            case "eMail":  // eMail 이메일
                result = staffRepository.findeMailCount(uid);
                break;

        }



        return result;
    }


    @Transactional
    public long getfindeUserNo(String uid, String identityNo) {

        long result = staffRepository.findeUserNo(uid,identityNo);


        return result;
    }




    @Transactional
    public Long getStaffCount() {
        return staffRepository.count();
    }

    @Transactional
    public StaffDto getPost(Long id) {
        Optional<StaffEntity> staffEntityWrapper = staffRepository.findById(id);
        StaffEntity staffEntity = staffEntityWrapper.get();

        return this.convertEntityToDto(staffEntity);
    }

    @Transactional
    public Long savePost(StaffDto staffDto) {
        return staffRepository.save(staffDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        staffRepository.deleteById(id);
    }

    @Transactional
    public List<StaffDto> searchPosts(SearchDto searchDto) {

         String keyword = searchDto.getKeyword();           // 검색 키워드
         String searchType = searchDto.getSearchType();        // 검색 유형


        List<StaffEntity> staffEntities = null;

        switch (searchType) {
            case "uid":  // uid   아이디
                staffEntities =  staffRepository.findByUidContaining(keyword);
                break;
            case "fullName":  // fullName 이름
                staffEntities =  staffRepository.findByFullNameContaining(keyword);
                break;
            case "identityNo": // identityNo  사원번호
                staffEntities =  staffRepository.findByIdentityNoContaining(keyword);
                break;
            case "eMail":  // eMail 이메일
                staffEntities =  staffRepository.findByeMailContaining(keyword);
                break;
            case "hp":  // hp 헨드폰 번호
                staffEntities =  staffRepository.findByHpContaining(keyword);
                break;
        }

        List<StaffDto> staffDtotoList = new ArrayList<>();

        for (StaffEntity staffEntity : staffEntities) {
            staffDtotoList.add(this.convertEntityToDto(staffEntity));
        }

        return staffDtotoList;
    }


    private StaffDto convertEntityToDto(StaffEntity staffEntity) {
        return StaffDto.builder()
                .id(staffEntity.getId())
                .uid(staffEntity.getUid())
                .name(staffEntity.getName())
                .fName(staffEntity.getFName())
                .lName(staffEntity.getLName())
                .fullName(staffEntity.getFullName())
                .identityNo(staffEntity.getIdentityNo())
                .pw(staffEntity.getPw())
                .sex(staffEntity.getSex())
                .rankId(staffEntity.getRankId())
                .positionId(staffEntity.getPositionId())
                .departmentId(staffEntity.getDepartmentId())
                .head(staffEntity.getHead())
                .utype(staffEntity.getUtype())
                .auth(staffEntity.getAuth())
                .concurrentPosition(staffEntity.getConcurrentPosition())
                .userId(staffEntity.getUserId())
                .eMail(staffEntity.getEMail())
                .hp(staffEntity.getHp())
                .seq(staffEntity.getSeq())
                .syncUse(staffEntity.getSyncUse())
                .syncSystem(staffEntity.getSyncSystem())
                .fingerPrint(staffEntity.getFingerPrint())
                .cardNo(staffEntity.getCardNo())
                .del(staffEntity.getDel())
                .memo(staffEntity.getMemo())
                .createdDate(staffEntity.getCreatedDate())
                .modifiedDate(staffEntity.getModifiedDate())
                .deleteDate(staffEntity.getDeleteDate())
                .build();
    }
}
