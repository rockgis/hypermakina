package com.mslk.sns.department.service;

import com.mslk.sns.department.domain.entity.DepartmentEntity;
import com.mslk.sns.department.domain.repository.DepartmentRepository;
import com.mslk.sns.department.dto.DepartmentDto;
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
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<DepartmentDto> getDepartmentlist(Integer pageNum) {
        Page<DepartmentEntity> page = departmentRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

        List<DepartmentEntity> departmentEntities = page.getContent();
        List<DepartmentDto> departmentDtotoList = new ArrayList<>();

        for (DepartmentEntity departmentEntity : departmentEntities) {
            departmentDtotoList.add(this.convertEntityToDto(departmentEntity));
        }

        return departmentDtotoList;
    }

    @Transactional
    public Long getDepartmentCount() {
        return departmentRepository.count();
    }

    @Transactional
    public DepartmentDto getPost(Long id) {
        Optional<DepartmentEntity> departmentEntityWrapper = departmentRepository.findById(id);
        DepartmentEntity departmentEntity = departmentEntityWrapper.get();

        return this.convertEntityToDto(departmentEntity);
    }

    @Transactional
    public Long savePost(DepartmentDto departmentDto) {
        return departmentRepository.save(departmentDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        departmentRepository.deleteById(id);
    }

     @Transactional
     public List<DepartmentDto> searchPosts(SearchDto searchDto) {

         String keyword = searchDto.getKeyword();           // 검색 키워드
         String searchType = searchDto.getSearchType();        // 검색 유형


        List<DepartmentEntity> departmentEntities = null;

        switch (searchType) {
            case "uid":  // uid   부서 아이디
                departmentEntities =  departmentRepository.findByUidContaining(keyword);
                break;
            case "name":  // 부서 이름
                departmentEntities =  departmentRepository.findByNameContaining(keyword);
                break;

        }

        List<DepartmentDto> departmentList = new ArrayList<>();

        for (DepartmentEntity departmentEntity : departmentEntities) {
            departmentList.add(this.convertEntityToDto(departmentEntity));
        }

        return departmentList;
    }


    private DepartmentDto convertEntityToDto(DepartmentEntity departmentEntity) {
        return DepartmentDto.builder()
                .id(departmentEntity.getId())
                .uid(departmentEntity.getUid())
                .name(departmentEntity.getName())
                .upperId(departmentEntity.getUpperId())
                .lftId(departmentEntity.getLftId())
                .rgtId(departmentEntity.getRgtId())
                .depth(departmentEntity.getDepth())
                .seq(departmentEntity.getSeq())
                .syncUse(departmentEntity.getSyncUse())
                .treeId(departmentEntity.getTreeId())
                .root(departmentEntity.getRoot())
                .del(departmentEntity.getDel())
                .memo(departmentEntity.getMemo())
                .createdDate(departmentEntity.getCreatedDate())
                .modifiedDate(departmentEntity.getModifiedDate())
                .deleteDate(departmentEntity.getDeleteDate())
                .build();
    }
}
