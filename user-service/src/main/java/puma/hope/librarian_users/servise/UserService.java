package puma.hope.librarian_users.servise;

import puma.hope.librarian_users.model.User;

import java.util.List;

public interface UserService {



    User create(User user);

    User update(User user);

    List<User> findAll();

    User findUserById(Long id);
}
