package com.mslk.sns.staff.service;

import com.mslk.sns.staff.domain.entity.StaffEntity;
import com.mslk.sns.staff.domain.repository.StaffRepository;
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

    /* @Transactional
    public List<StaffDto> searchPosts(StaffDto staffDto) {

        String dcd = gitta0001Dto.getDcd();
        String usrNm =  gitta0001Dto.getUsrNm();
        String usrEn = gitta0001Dto.getUsrEn();
        String emNm = gitta0001Dto.getEmNm();
        String nrIpAr = gitta0001Dto.getNrIpAr();
        String earEhf = gitta0001Dto.getEarEhf();

        System.out.println(dcd);
        System.out.println(usrNm);
        System.out.println(usrEn);
        System.out.println(emNm);
        System.out.println(nrIpAr);
        System.out.println(earEhf);

        List<StaffEntity> gitta0001Entities = null;

        if(!dcd.isEmpty()){
            gitta0001Entities = gitta0001Repository.findByDcdContaining(dcd);
        } else if (!usrNm.isEmpty()) {
            gitta0001Entities = gitta0001Repository.findByUsrNmContaining(usrNm);
        }else if (!usrEn.isEmpty()) {
            gitta0001Entities = gitta0001Repository.findByUsrEnContaining(usrEn);
        }else if (!emNm.isEmpty()) {
            gitta0001Entities = gitta0001Repository.findByEmNmContaining(emNm);
        }else if (!nrIpAr.isEmpty()) {
            gitta0001Entities = gitta0001Repository.findByNrIpArContaining(nrIpAr);
        }else if (!earEhf.equals("A")) {
            gitta0001Entities = gitta0001Repository.findByEarEhfContaining(earEhf);
        }else{

            Page<Gitta0001Entity> page = gitta0001Repository.findAll(PageRequest.of(0, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

            gitta0001Entities = page.getContent();
        }

        List<Gitta0001Dto> gitta0001DtoList = new ArrayList<>();

        if (gitta0001Entities.isEmpty()) return gitta0001DtoList;

        for (Gitta0001Entity gitta0001Entity : gitta0001Entities) {
            gitta0001DtoList.add(this.convertEntityToDto(gitta0001Entity));
        }

        return gitta0001DtoList;
    }

     */

    public Integer[] getPageList(Integer curPageNum) {
        // 총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getStaffCount());

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
                .hP(staffEntity.getHP())
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
