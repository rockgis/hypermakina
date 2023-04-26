package com.mslk.sns.logmng.service;

import com.mslk.sns.logmng.domain.entity.MmsLogEntity;
import com.mslk.sns.logmng.domain.repository.MmsLogRepository;
import com.mslk.sns.logmng.dto.MmsLogDto;
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
public class MmsLogService {
    private MmsLogRepository mmsLogRepository;

    private static final int BLOCK_PAGE_NUM_COUNT = 10;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<MmsLogDto> getMmsLoglist(Integer pageNum) {
        Page<MmsLogEntity> page = mmsLogRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "createdDate")));

        List<MmsLogEntity> mmsLogEntities = page.getContent();
        List<MmsLogDto> mmsLogDtoList = new ArrayList<>();

        for (MmsLogEntity mmsLogEntity : mmsLogEntities) {
            mmsLogDtoList.add(this.convertEntityToDto(mmsLogEntity));
        }

        return mmsLogDtoList;
    }

    @Transactional
    public Long getMmsLogCount() {
        return mmsLogRepository.count();
    }

    @Transactional
    public MmsLogDto getPost(Long id) {
        Optional<MmsLogEntity> mmsLogEntityWrapper = mmsLogRepository.findById(id);
        MmsLogEntity mmsLogEntity = mmsLogEntityWrapper.get();

        return this.convertEntityToDto(mmsLogEntity);
    }

    @Transactional
    public Long savePost(MmsLogDto mmsLogDto) {
        return mmsLogRepository.save(mmsLogDto.toEntity()).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        mmsLogRepository.deleteById(id);
    }

    @Transactional
    public List<MmsLogDto> searchPosts(String keyword) {
        List<MmsLogEntity> mmsLogEntities = mmsLogRepository.findByMmsTelContaining(keyword);
        List<MmsLogDto> mmsLogDtoList = new ArrayList<>();

        if (mmsLogEntities.isEmpty()) return mmsLogDtoList;

        for (MmsLogEntity mmsLogEntity : mmsLogEntities) {
            mmsLogDtoList.add(this.convertEntityToDto(mmsLogEntity));
        }

        return mmsLogDtoList;
    }

    private MmsLogDto convertEntityToDto(MmsLogEntity mmsLogEntity) {
        return MmsLogDto.builder()
                .id(mmsLogEntity.getId())
                .mmsTel(mmsLogEntity.getMmsTel())
                .mmsSub(mmsLogEntity.getMmsSub())
                .mmsContent(mmsLogEntity.getMmsContent())
                .createdDate(mmsLogEntity.getCreatedDate())
                .build();
    }
}
