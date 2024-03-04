package study.chatroom.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.chatroom.dto.user.UserInfoResponse;
import study.chatroom.repo.UserRepository;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository memberRepository;
    private final PasswordEncoder encoder;

    @Transactional(readOnly = true)
    public UserInfoResponse getMemberInfo(String idx) {
        long userId = convertToPk(idx);
        return memberRepository.findById(userId)
                .map(UserInfoResponse::from)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원입니다."));
    }

    private static long convertToPk(String idx) {
        long userId = Long.parseLong(idx);
        return userId;
    }


}
