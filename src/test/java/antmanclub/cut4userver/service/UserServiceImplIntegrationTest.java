package antmanclub.cut4userver.service;

import antmanclub.cut4userver.user.domain.User;
import antmanclub.cut4userver.user.dto.JoinDto;
import antmanclub.cut4userver.user.dto.LoginDto;
import antmanclub.cut4userver.user.dto.UserDto;
import antmanclub.cut4userver.user.repository.UserRepository;
import antmanclub.cut4userver.user.service.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class UserServiceImplIntegrationTest {

    @Autowired
    UserServiceImpl userService;
    @Autowired UserRepository userRepository;

    @Test
    @Commit
    void join() {
        //given
        JoinDto user = new JoinDto();
        user.setEmail("asdf@naver.com");
        user.setPassword("asdf");
        user.setConfirmPassword("asdf");
        user.setName("name");

        //when
        UserDto savedUser = userService.join(user);

        //then
        User findUser = userService.findOne(savedUser.getName()).get();
        Assertions.assertThat(user.getName()).isEqualTo(findUser.getName());
    }

    @Test
    void 이메일_중복() {
        //given
        JoinDto user = new JoinDto();
        user.setEmail("asdf@naver.com");
        user.setPassword("asdf");
        user.setConfirmPassword("asdf");
        user.setName("name");

        JoinDto user1 = new JoinDto();
        user1.setEmail("asdf@naver.com");
        user1.setPassword("qwer");
        user1.setConfirmPassword("qwer");
        user1.setName("zxcv");

        //when
        UserDto savedUser = userService.join(user);
        IllegalStateException e= org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> userService.join(user1));


        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

    @Test
    void 비밀번호_확인실패() {
        //given
        JoinDto user = new JoinDto();
        user.setEmail("qwer@naver.com");
        user.setPassword("asdf");
        user.setConfirmPassword("asdff");
        user.setName("name1");

        //when
        IllegalStateException e= org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> userService.join(user));

        //then
        assertThat(e.getMessage()).isEqualTo("비밀번호가 일치하지 않습니다.");

    }

    @Test
    void login() {
        //given
        JoinDto user = new JoinDto();
        user.setEmail("remicon99@naver.com");
        user.setPassword("1e3q2w$r");
        user.setConfirmPassword("1e3q2w$r");
        user.setName("taeseung");
        UserDto savedUser = userService.join(user);

        LoginDto loginUser = new LoginDto();
        loginUser.setEmail("remicon99@naver.com");
        loginUser.setPassword("1e3q2w$r");

        //when
        UserDto loggedInUser = userService.login(loginUser);

        //then
        User findUser = userService.findOne(loggedInUser.getName()).get();
        Assertions.assertThat(user.getName()).isEqualTo(findUser.getName());


    }

    @Test
    void 이메일_없음() {
        //given
        JoinDto user = new JoinDto();
        user.setEmail("remicon99@naver.com");
        user.setPassword("1e3q2w$r");
        user.setConfirmPassword("1e3q2w$r");
        user.setName("taeseung");
        UserDto savedUser = userService.join(user);

        LoginDto loginUser = new LoginDto();
        loginUser.setEmail("remicon9@naver.com");
        loginUser.setPassword("1e3q2w$r");

        //when
        IllegalStateException e= org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> userService.login(loginUser));

        //then
        assertThat(e.getMessage()).isEqualTo("존재하지 않는 이메일입니다.");

    }

    @Test
    void 비밀번호_틀림() {
        //given
        JoinDto user = new JoinDto();
        user.setEmail("remicon99@naver.com");
        user.setPassword("1e3q2w$r");
        user.setConfirmPassword("1e3q2w$r");
        user.setName("taeseung");
        UserDto savedUser = userService.join(user);

        LoginDto loginUser = new LoginDto();
        loginUser.setEmail("remicon99@naver.com");
        loginUser.setPassword("1e3q2w4r");

        //when
        IllegalStateException e= org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> userService.login(loginUser));

        //then
        assertThat(e.getMessage()).isEqualTo("비밀번호가 틀렸습니다.");

    }

    @Test
    void 프로필_수정(){
        //given
        JoinDto joinUser = new JoinDto();
        joinUser.setEmail("asdf@naver.com");
        joinUser.setPassword("asdf");
        joinUser.setConfirmPassword("asdf");
        joinUser.setName("name");
        UserDto savedUser = userService.join(joinUser);

        String newName = "newName";
        String newImg = "newImgSrc";

        UserDto userDto = new UserDto();
        userDto.setEmail(savedUser.getEmail());
        userDto.setName(newName);
        userDto.setProfileimg(newImg);


        // when
        UserDto editedUser = userService.editProfile(userDto);


        // then
        User findUser = userService.findOne(editedUser.getName()).get();
        Assertions.assertThat(editedUser.getName()).isEqualTo(newName);
        Assertions.assertThat(editedUser.getEmail()).isEqualTo(userDto.getEmail());
        Assertions.assertThat(editedUser.getProfileimg()).isEqualTo(newImg);
    }

    @Test
    void 프로필_수정_이름중복(){
        //given
        JoinDto joinUser = new JoinDto();
        joinUser.setEmail("asdf@naver.com");
        joinUser.setPassword("asdf");
        joinUser.setConfirmPassword("asdf");
        joinUser.setName("name");
        UserDto savedUser1 = userService.join(joinUser);

        joinUser.setEmail("qwer@naver.com");
        joinUser.setPassword("asdf");
        joinUser.setConfirmPassword("asdf");
        joinUser.setName("name2");
        UserDto savedUser2 = userService.join(joinUser);

        String newName = "name";

        UserDto userDto = new UserDto();
        userDto.setEmail(savedUser2.getEmail());
        userDto.setName(newName);

        // when
        IllegalStateException e= org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> userService.editProfile(userDto));

        // then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");

    }

    @Test
    void findOne() {
    }
}