package antmanclub.cut4userver.user.controller;

import antmanclub.cut4userver.aws.AwsUpload;
import antmanclub.cut4userver.user.dto.JoinDto;
import antmanclub.cut4userver.user.dto.LoginDto;
import antmanclub.cut4userver.user.dto.UserDto;
import antmanclub.cut4userver.user.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final AwsUpload awsUpload;

//    @GetMapping("/")
//    public String home(){
//        return "home";
//    }
//
//    @GetMapping("/join")
//    public String joinForm(){
//        return "join";
//    }
//
//    @PostMapping("/join")
//    public String join(JoinDto joinDto){
//        userService.join(joinDto);
//
//        return "redirect:/";
//    }
//
//    @GetMapping("/login")
//    public String loginForm(){
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(LoginDto loginDto){
//        userService.login(loginDto);
//
//        return "redirect:/";
//    }

    @PostMapping(value="/user/edit",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveDiary(HttpServletRequest request, @RequestParam(value="image") MultipartFile image, UserDto userDto) throws IOException {
        String imgSrc = awsUpload.upload(image, "image");
        userDto.setProfileimg(imgSrc);
        userService.editProfile(userDto);
        return "redirect:/";
    }
}
