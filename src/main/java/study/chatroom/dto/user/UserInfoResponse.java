package study.chatroom.dto.user;


import study.chatroom.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.chatroom.entity.UserLevel;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {

        private Long id;
        private String email;
        private String name;

        private UserLevel userLevel;

        private LocalDateTime createdAt;

    public static UserInfoResponse from(User member) {
        return new UserInfoResponse(
                member.getId(),
                member.getEmail(),
                member.getName(),
                member.getUserLevel(),
                member.getCreatedAt()
        );
    }

}
