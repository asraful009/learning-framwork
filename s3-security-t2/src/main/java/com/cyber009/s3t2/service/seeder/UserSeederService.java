package com.cyber009.s3t2.service.seeder;

import com.cyber009.s3t2.entity.RoleEntity;
import com.cyber009.s3t2.entity.UserEntity;
import com.cyber009.s3t2.repository.UserRepository;
import com.cyber009.s3t2.service.PasswordService;
import com.cyber009.s3t2.service.RoleService;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserSeederService {

    private final PasswordService passwordService;
    private final UserRepository userRepository;

    public void seedUser() {
        log.info("Initializing Seed User");
        initUser();
    }

    private void initUser() {
        log.info("Initializing User");
        List<UserEntity> entities = g();
        for (UserEntity entity : entities) {
            if(userRepository.existsByEmail(entity.getEmail())) {
                log.info("User with email {} already exists, skipping", entity.getEmail());
                continue;
            }
            userRepository.save(entity);
        }
    }

    private List<UserEntity> g() {
        List<UserEntity> entities = new LinkedList<>();
        Faker faker = new Faker();
        for(int i = 0; i < 10; i++) {
//            String email = faker.internet().emailAddress();
            String email = String.format("%s.%d@%s.com",
                    "abc",
                    i,
                    "gmail");
            UserEntity user = UserEntity.builder()
                    .firstname(faker.name().firstName())
                    .lastname(faker.name().lastName())
                    .email(email)
                    .password(passwordService.encodeWithPepper(email, "1122"))
                    .role("USER")
                    .build();
            entities.add(user);
        }
        return entities;
    }
}
