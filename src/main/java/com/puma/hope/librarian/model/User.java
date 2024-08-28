package com.puma.hope.librarian.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Schema(name = "id", example = "1", description = "User ID, generated by the DataBase")
    Long id;

    @Email(message = "Invalid email!")
    @Schema(name = "email", example = "nickname@mail.com")
    String email;

    @Pattern(regexp = "[^ ]*", message = "There must be no space symbols in login!")
    @NotEmpty(message = "Login may not be empty!")
    @Schema(name = "login", example = "YourNickname", description = "Login may not be empty and may not contain space symbols")
    String login;

    // Была мысль написать рандомайзер, предлагающий варианты логина
    // Это дело бэка, а не фронта, потому что проверять бы на уникальность,
    // прежде чем предлагать юзеру
    @NotEmpty(message = "Name may not be empty!")
    @Schema(name = "name", example = "Firstname Lastname", description = "Displayed name. May not be empty")
    String name;

    @Past(message = "Birth date may not be in future!")
    @Schema(name = "birthday", example = "1946-08-20", description = "Birthday may not be in future. Date format: YYYY-MM-DD")
    LocalDate birthday;

    final Set<Long> friendsIds = new HashSet<>();
}