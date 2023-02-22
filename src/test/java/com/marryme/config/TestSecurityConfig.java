package com.marryme.config;


import com.marryme.domain.User;
import com.marryme.repository.UserRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {

    @MockBean
    private UserRepository userRepository;

    @BeforeTestMethod
    public void securitySetUp() {
        given(userRepository.findById(anyLong())).willReturn(
                Optional.of(
                        new User(99999L, 1L, "욱창2", LocalDateTime.now(), "cw")
                )
        );
    }

}
