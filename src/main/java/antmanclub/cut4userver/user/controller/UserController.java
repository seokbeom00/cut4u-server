package antmanclub.cut4userver.user.controller;

import antmanclub.cut4userver.aws.AwsUpload;
import antmanclub.cut4userver.user.dto.*;
import antmanclub.cut4userver.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @PatchMapping(path="/user/editProfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UserProfileUpdateResponseDto editProfile(@RequestParam(value="image") MultipartFile image,
                                                    @RequestParam(value="name") String name,
                                                    @RequestParam(value = "email") String email)
            throws IOException {
        String imgSrc = awsUpload.upload(image, "image");
        return userService.editProfile(UserProfileUpdateRequestDto.builder()
                .name(name)
                .email(email)
                .profileimg(imgSrc)
                .build());
    }

    @PostMapping("/user/follow")
    public SuccessResponseDto userFollow(@RequestBody UserFollowRequestDto userFollowRequestDto){
        return userService.userFollow(userFollowRequestDto);
    }
}
