package antmanclub.cut4userver.user.controller;

import antmanclub.cut4userver.aws.AwsUpload;
import antmanclub.cut4userver.user.dto.JoinRequestDto;
import antmanclub.cut4userver.user.dto.LoginRequestDto;
import antmanclub.cut4userver.user.dto.SuccessResponseDto;
import antmanclub.cut4userver.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AwsUpload awsUpload;

    @PostMapping("/user/login")
    public SuccessResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        return userService.login(loginRequestDto);
    }

    @PostMapping("/user/join")
    public SuccessResponseDto join(@RequestBody JoinRequestDto requestDto){
        return userService.join(requestDto);
    }

    @GetMapping("/user/duplecheck/{email}")
    public SuccessResponseDto emailDupleCheck(@PathVariable String email){
        return userService.emailDupleCheck(email);
    }
}
