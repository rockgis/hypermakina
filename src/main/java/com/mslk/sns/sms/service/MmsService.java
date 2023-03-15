package com.mslk.sns.sms.service;

import com.mslk.sns.rank.dto.RankDto;
import com.mslk.sns.sms.domain.entity.MmsEntity;
import com.mslk.sns.sms.dto.MmsDto;
import com.mslk.sns.sms.domain.repository.MmsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class MmsService {

    private MmsRepository mmsRepository;

    @Transactional
    public String savePost(MmsDto mnsDto) {
        return mmsRepository.save(mnsDto.toEntity()).getStatus();
    }

}
