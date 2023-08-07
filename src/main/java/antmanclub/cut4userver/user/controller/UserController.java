package antmanclub.cut4userver.user.controller;

import antmanclub.cut4userver.aws.AwsUpload;
import antmanclub.cut4userver.user.dto.LoginRequestDto;
import antmanclub.cut4userver.user.dto.LoginResponseDto;
import antmanclub.cut4userver.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AwsUpload awsUpload;

    @GetMapping("/user/login")
    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        return userService.login(loginRequestDto);
    }
}
