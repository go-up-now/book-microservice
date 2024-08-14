package com.devteria.profile.service;

import com.devteria.profile.dto.request.UserProfileCreateRequest;
import com.devteria.profile.dto.response.UserProfileResponse;

public interface UserProfileService {
    UserProfileResponse createProfile(UserProfileCreateRequest request);
    UserProfileResponse getProfile(String id);
}
