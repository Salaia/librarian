package puma.hope.librarian_users.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puma.hope.librarian_users.model.User;

@Repository("userJPARepository")
public interface UserJPARepository extends JpaRepository<User, Long> {

}
