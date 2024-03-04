package study.chatroom.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import study.chatroom.entity.User;
import study.chatroom.entity.UserLevel;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    List<User> findAllByUserLevel(UserLevel type);

   // Optional<User> findBySecret(UUID uuid);

}
