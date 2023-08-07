package antmanclub.cut4userver.user.service;

import antmanclub.cut4userver.config.SecurityConfig;
import antmanclub.cut4userver.user.SemiToken.CurrentUser;
import antmanclub.cut4userver.user.domain.User;
import antmanclub.cut4userver.user.dto.JoinRequestDto;
import antmanclub.cut4userver.user.dto.LoginRequestDto;
import antmanclub.cut4userver.user.dto.SuccessResponseDto;
import antmanclub.cut4userver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final SecurityConfig securityConfig = new SecurityConfig();;

    @Transactional
    public SuccessResponseDto login(LoginRequestDto loginRequestDto) {
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
        return SuccessResponseDto.builder().success(true).build();
    }

    public SuccessResponseDto join(JoinRequestDto requestDto) {
        userRepository.findByName(requestDto.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });
        userRepository.findByEmail(requestDto.getEmail()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        if (!Objects.equals(requestDto.getPassword(), requestDto.getConfirmPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
        String encodePw = securityConfig.getPasswordEncoder().encode(requestDto.getPassword());
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(encodePw);
        try {
            user.setName(requestDto.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        user.setProfileimg(""); //나중에 기본 이미지로 바꿔줘야함
        userRepository.save(user);
        return SuccessResponseDto.builder().success(true).build();
    }
}
