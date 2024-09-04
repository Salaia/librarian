package com.puma.hope.librarian_adviser.storage;

import com.puma.hope.librarian_adviser.exception.EntityNotFoundException;
import com.puma.hope.librarian_adviser.storage.face.UserStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("userStorageImpl")
@RequiredArgsConstructor
public class UserStorageImpl implements UserStorage {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void checkUserExistence(Long id) {
        final String sql = "select COUNT(USER_ID) from librarian.users where USER_ID = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        if (count == null || count == 0) {
            throw new EntityNotFoundException("User with id \"" + id + "\" not found.");
        }
    }
}
