package com.devteria.profile.controller;

import com.devteria.profile.dto.request.UserProfileCreateRequest;
import com.devteria.profile.dto.response.UserProfileResponse;
import com.devteria.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileController {
    UserProfileService userProfileService;

    @PostMapping
    public UserProfileResponse create(@RequestBody UserProfileCreateRequest request){
        return userProfileService.createProfile(request);
    }

    @GetMapping("/{id}")
    public UserProfileResponse getProfile(@PathVariable String id){
        return userProfileService.getProfile(id);
    }
}
