package study.chatroom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.chatroom.common.ApiResponse;
import study.chatroom.dto.user.signin.req.SigninRequest;
import study.chatroom.dto.user.signup.req.SignupRequest;
import study.chatroom.service.SignService;


@RequiredArgsConstructor
@RestController
@RequestMapping
public class SignController {
    private final SignService signService;


    @PostMapping("/sign-up")
    public ApiResponse signUp(@RequestBody SignupRequest request) {
        return ApiResponse.success(signService.registMember(request));
    }


    @PostMapping("/sign-in")
    public ApiResponse signIn(@RequestBody SigninRequest request) {
        return ApiResponse.success(signService.signIn(request));
    }
}
