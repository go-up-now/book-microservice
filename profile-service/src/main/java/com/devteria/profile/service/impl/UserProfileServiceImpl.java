package com.devteria.profile.service.impl;

import com.devteria.profile.dto.request.UserProfileCreateRequest;
import com.devteria.profile.dto.response.UserProfileResponse;
import com.devteria.profile.mapper.UserProfileMapper;
import com.devteria.profile.repository.UserProfileRepository;
import com.devteria.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    @Override
    public UserProfileResponse createProfile(UserProfileCreateRequest request) {
        var userProfile = userProfileMapper.toUserProfile(request);

        return userProfileMapper.toUserProfileResponse(userProfileRepository.save(userProfile));
    }

    @Override
    public UserProfileResponse getProfile(String id) {
        return userProfileMapper.toUserProfileResponse(userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User profile not found!")));
    }
}
