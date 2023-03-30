package com.mslk.sns.sms.service;

import com.mslk.sns.sms.domain.repository.LguMmsRepository;
import com.mslk.sns.sms.domain.repository.MmsRepository;
import com.mslk.sns.sms.dto.LguMmsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class LguMmsService {

    private LguMmsRepository lguMmsRepository;

    @Transactional
    public String savePost(LguMmsDto lguMmsDto) {
        return lguMmsRepository.save(lguMmsDto.toEntity()).getStatus();
    }

}
