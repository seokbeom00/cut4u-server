package antmanclub.cut4userver.user.controller;

import antmanclub.cut4userver.user.dto.JoinDto;
import antmanclub.cut4userver.user.dto.LoginDto;
import antmanclub.cut4userver.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String join(JoinForm form){
        JoinDto joinDto = new JoinDto();
        joinDto.setEmail(form.getJoinEmail());
        joinDto.setPassword(form.getJoinPassword());
        joinDto.setConfirmPassword(form.getJoinConfirmPassword());
        joinDto.setName(form.getJoinName());
        userService.join(joinDto);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(LoginForm form){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(form.getLoginEmail());
        loginDto.setPassword(form.getLoginPassword());
        userService.login(loginDto);

        return "redirect:/";
    }
}
