package puma.hope.librarian.event.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import puma.hope.librarian.event.model.User;

@Repository("userJPARepository")
public interface UserJPARepository extends JpaRepository<User, Long> {

}
