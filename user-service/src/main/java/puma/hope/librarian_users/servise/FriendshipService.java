package puma.hope.librarian_users.servise;

import puma.hope.librarian_users.model.User;

import java.util.List;

public interface FriendshipService {
    User addFriend(Long userId, Long friendId);

    User removeFriend(Long userId, Long friendId);

    List<User> findFriends(Long userId);

    List<User> findCommonFriends(Long userId, Long otherUserId);
}
