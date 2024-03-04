package study.chatroom.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.chatroom.dto.user.signin.req.SigninRequest;
import study.chatroom.dto.user.signin.res.SigninResponse;
import study.chatroom.dto.user.signup.req.SignupRequest;
import study.chatroom.dto.user.signup.res.SignUpResponse;
import study.chatroom.entity.User;
import study.chatroom.repo.UserRepository;
import study.chatroom.security.TokenProvider;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignService {
    private final UserRepository memberRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder encoder;

    @Transactional
    public SignUpResponse registMember(SignupRequest request) {
        User member = memberRepository.save(User.from(request, encoder));
        try {
            memberRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
        return SignUpResponse.from(member);
    }

    @Transactional(readOnly = true)
    public SigninResponse signIn(SigninRequest request) {
        log.info("enter email={}", request.getEmail());
        log.info("enter password={}", request.getPassword());
        User member = memberRepository.findByEmail(request.getEmail())
                .filter(it -> encoder.matches(request.getPassword(), it.getPassword()))
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));
        String token = tokenProvider.createToken(String.format("%s:%s", member.getId(), member.getUserLevel()));
        return new SigninResponse(member.getName(), member.getUserLevel(), token);
    }
}
