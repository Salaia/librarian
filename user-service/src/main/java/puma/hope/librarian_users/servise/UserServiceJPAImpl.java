package puma.hope.librarian_users.servise;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import puma.hope.librarian_users.exception.EntityNotFoundException;
import puma.hope.librarian_users.model.User;
import puma.hope.librarian_users.storage.UserJPARepository;

import java.util.List;
import java.util.Optional;

@Service("userServiceJPAImpl")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceJPAImpl implements UserService {

    final UserJPARepository userStorage;



    @Override
    public User create(User user) {
        return userStorage.save(user);
    }

    @Override
    public User update(User user) {
        return userStorage.save(user);
    }

    @Override
    public List<User> findAll() {
        return userStorage.findAll();
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> optionalUser = userStorage.findById(id);
        if (optionalUser.isPresent()) return optionalUser.get();
        else throw new EntityNotFoundException("Not found: user by ID " + id);
    }
}
