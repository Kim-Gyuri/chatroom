package study.chatroom.dto.chat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
//@Entity
@Builder
public class ChatRoom implements Serializable {

    private static final long serialVersionUID = 6494678977089006639L;

 //   @Id @GeneratedValue(strategy = IDENTITY)
   // private Long id;

    private String roomId;
    private String name;



    public static ChatRoom create(String name) {
        return ChatRoom.builder()
                .roomId(UUID.randomUUID().toString())
                .name(name)
                .build();

    }
}
