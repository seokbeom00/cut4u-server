package antmanclub.cut4userver.user.service;

import antmanclub.cut4userver.SecurityConfig;
import antmanclub.cut4userver.user.controller.LoginForm;
import antmanclub.cut4userver.user.domain.User;
import antmanclub.cut4userver.user.dto.JoinDto;
import antmanclub.cut4userver.user.dto.LoginDto;
import antmanclub.cut4userver.user.dto.UserDto;
import antmanclub.cut4userver.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final SecurityConfig securityConfig = new SecurityConfig();
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto join(JoinDto joinDto) {
        validateDuplicateUser(joinDto.getEmail());
        confirmPassword(joinDto.getPassword(), joinDto.getConfirmPassword());

        String encodePw = securityConfig.getPasswordEncoder().encode(joinDto.getPassword());

        User user = new User();
        user.setEmail(joinDto.getEmail());
        user.setPassword(encodePw);
        user.setName(joinDto.getName());
        user.setProfileimg("imgSrc");
        userRepository.save(user);
        return userToUserDto(user);
    }

    private void confirmPassword(String pw1, String pw2){
        if (!Objects.equals(pw1, pw2)){
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
    }

    private void validateDuplicateUser(String email) {
        userRepository.findByEmail(email).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    @Override
    public UserDto login(LoginDto loginDto) {
        checkEmail(loginDto.getEmail());
        checkPassword(loginDto);
        Optional<User> user = userRepository.findByEmail(loginDto.getEmail());
        return userToUserDto(user.get());
    }
    private void checkEmail(String email){
        if(userRepository.findByEmail(email).isEmpty()){
            throw new IllegalStateException("존재하지 않는 이메일입니다.");
        }
    }

    private void checkPassword(LoginDto loginDto){
        userRepository.findByEmail(loginDto.getEmail()).ifPresent(m ->{
            if(!securityConfig.getPasswordEncoder().matches(loginDto.getPassword(), m.getPassword())){
                throw new IllegalStateException("비밀번호가 틀렸습니다.");
            }
        });
    }


    @Override
    public Optional<User> findOne(String name) {
        return userRepository.findByName(name);
    }

    private UserDto userToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setProfileImg(user.getProfileimg());
        return userDto;
    }
}
