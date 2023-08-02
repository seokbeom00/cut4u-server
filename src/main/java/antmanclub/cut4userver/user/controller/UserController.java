package antmanclub.cut4userver.user.controller;

import antmanclub.cut4userver.user.dto.JoinDto;
import antmanclub.cut4userver.user.dto.LoginDto;
import antmanclub.cut4userver.user.dto.UserDto;
import antmanclub.cut4userver.user.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/join")
    public String joinForm(){
        return "join";
    }

    @PostMapping("/join")
    public String join(JoinDto joinDto){
        userService.join(joinDto);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(LoginDto loginDto){
        userService.login(loginDto);

        return "redirect:/";
    }

    @ResponseBody   // Long 타입을 리턴하고 싶은 경우 붙여야 함 (Long - 객체)
    @PostMapping(value="/user/edit",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveDiary(HttpServletRequest request, UserDto userDto) throws IOException {
        userService.editProfile(userDto);
        return "redirect:/";
    }
}
