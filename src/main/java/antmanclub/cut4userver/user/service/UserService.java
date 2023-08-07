package antmanclub.cut4userver.user.service;

import antmanclub.cut4userver.config.SecurityConfig;
import antmanclub.cut4userver.user.SemiToken.CurrentUser;
import antmanclub.cut4userver.user.domain.User;
import antmanclub.cut4userver.user.dto.LoginRequestDto;
import antmanclub.cut4userver.user.dto.LoginResponseDto;
import antmanclub.cut4userver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SecurityConfig securityConfig = new SecurityConfig();;

    @Transactional
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        userRepository.findByEmail(loginRequestDto.getEmail()).ifPresent(m -> {
            if(!securityConfig.getPasswordEncoder().matches(loginRequestDto.getPassword(), m.getPassword())){
                throw new IllegalStateException("비밀번호가 틀렸습니다");
            }
        });
        //비밀번호가 맞으면 해당 이메일은 고유하므로 로그인 성공
        User user = userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(()-> new IllegalArgumentException("해당 유저가 없습니다"));
        CurrentUser currentUser = new CurrentUser();
        currentUser.setEmail(user.getEmail());
        currentUser.setName(user.getName());
        return LoginResponseDto.builder().success(true).build();
    }
}
