package puma.hope.librarian_users.servise;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import puma.hope.librarian_users.exception.EntityNotFoundException;
import puma.hope.librarian_users.model.Friendship;
import puma.hope.librarian_users.model.User;
import puma.hope.librarian_users.storage.FriendshipRepository;
import puma.hope.librarian_users.storage.UserJPARepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FriendshipServiceImpl implements FriendshipService {

    final FriendshipRepository friendshipRepository;
    final UserJPARepository userRepository;

    @Override
    public User addFriend(Long userId, Long friendId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) throw new EntityNotFoundException("Not found: user by ID: " + userId);
        Optional<User> optionalFriendCheck = userRepository.findById(friendId);
        if (optionalFriendCheck.isEmpty()) throw new EntityNotFoundException("Not found: user by ID: " + friendId);

        friendshipRepository.save(new Friendship(userId, friendId));

        Optional<User> optionalFriend = userRepository.findById(friendId);
        if (optionalFriend.isPresent()) return optionalFriend.get();
        else throw new EntityNotFoundException("Not found: user by ID: " + friendId);
    }

    @Override
    public User removeFriend(Long userId, Long friendId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) throw new EntityNotFoundException("Not found: user by ID: " + userId);
        Optional<User> optionalFriendCheck = userRepository.findById(friendId);
        if (optionalFriendCheck.isEmpty()) throw new EntityNotFoundException("Not found: user by ID: " + friendId);

        Optional<Friendship> optionalFriendship = friendshipRepository.findByUserIdAndFriendId(userId, friendId);
        if (optionalFriendship.isEmpty()) {
            throw new EntityNotFoundException("Not found: friendship between users with IDs "
                    + userId + " and " + friendId);
        } else {
            friendshipRepository.delete(optionalFriendship.get());
        }

        Optional<User> optionalFriend = userRepository.findById(friendId);
        if (optionalFriend.isPresent()) return optionalFriend.get();
        else throw new EntityNotFoundException("Not found: user by ID: " + friendId);
    }

    @Override
    public List<User> findFriends(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) throw new EntityNotFoundException("Not found: user by ID: " + userId);

        return friendshipRepository.findFriends(userId);
    }

    @Override
    public List<User> findCommonFriends(Long userId, Long otherUserId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) throw new EntityNotFoundException("Not found: user by ID: " + userId);
        Optional<User> optionalFriendCheck = userRepository.findById(otherUserId);
        if (optionalFriendCheck.isEmpty()) throw new EntityNotFoundException("Not found: user by ID: " + otherUserId);

        return friendshipRepository.findCommonFriends(userId, otherUserId);
    }
}
