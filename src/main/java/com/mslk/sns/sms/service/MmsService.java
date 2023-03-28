package com.mslk.sns.sms.service;

import com.mslk.sns.sms.dto.LguMmsDto;
import com.mslk.sns.sms.domain.repository.MmsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class MmsService {

    private MmsRepository mmsRepository;

    @Transactional
    public String savePost(LguMmsDto lguMmsDto) {
        return mmsRepository.save(lguMmsDto.toEntity()).getStatus();
    }

}
