package study.chatroom.dto.user.signin.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.chatroom.entity.UserLevel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SigninResponse {

        private String name;
        private UserLevel userLevel;
        private String token;


}
