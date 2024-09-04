package puma.hope.librarian_users.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import puma.hope.librarian_users.model.Friendship;
import puma.hope.librarian_users.model.User;

import java.util.List;
import java.util.Optional;

@Repository("friendshipRepository")
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    Optional<Friendship> findByUserIdAndFriendId(Long userId, Long friendId);

    @Query("select u " +
            " from User as u " +
            " where u.id in (select f.friendId " +
            " from Friendship as f " +
            " where f.id = :userId)")
    List<User> findFriends(Long userId);

    @Query("select u " +
            " from User as u" +
            " where u.id in (select f.id" +
            " from Friendship as f" +
            " where f.userId = :userId" +
            " and f.friendId in (select f1.friendId" +
            " from Friendship as f1" +
            " where f1.userId = :otherUserId))")
    List<User> findCommonFriends(Long userId, Long otherUserId);
}
