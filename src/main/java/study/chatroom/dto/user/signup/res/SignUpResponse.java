package study.chatroom.dto.user.signup.res;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.chatroom.entity.User;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class SignUpResponse {
   // private UUID id;
    private String email;
    private String name;

    public static SignUpResponse from(User user) {
        return new SignUpResponse(
               // user.getSecret(),
                user.getEmail(),
                user.getName()
        );

    }
}
