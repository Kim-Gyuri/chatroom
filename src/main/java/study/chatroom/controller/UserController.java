package study.chatroom.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.chatroom.common.ApiResponse;
import study.chatroom.security.UserAuthorize;
import study.chatroom.service.UserService;

@Slf4j
@RequiredArgsConstructor
@UserAuthorize
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping
    public ApiResponse getMemberInfo(@AuthenticationPrincipal User user) {
        log.info("username={}", user.getUsername());

       return ApiResponse.success(userService.getMemberInfo(user.getUsername()));
    }

}
