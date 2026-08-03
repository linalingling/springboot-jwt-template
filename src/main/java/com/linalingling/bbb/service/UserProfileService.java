package com.linalingling.bbb.service;

import com.linalingling.bbb.entity.UserProfile;
import com.linalingling.bbb.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.linalingling.bbb.entity.User;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfile createOrUpdateProfile(Long userId, String name, LocalDate birthDate) {
        Optional<UserProfile> existing = userProfileRepository.findByUserId(userId);

        if (existing.isPresent()) {
            //已存在, 更新
            UserProfile profile = existing.get();
            profile.setName(name);
            profile.setBirthDate(birthDate);
            return userProfileRepository.save(profile);
        } else {
            User user = new User();
            user.setId(userId);
            UserProfile newProfile = UserProfile.builder()
                    .user(user)
                    .name(name)
                    .birthDate(birthDate)
                    .build();

            return userProfileRepository.save(newProfile);

        }

    }
}

