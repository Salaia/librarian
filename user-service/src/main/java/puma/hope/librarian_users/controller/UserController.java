package puma.hope.librarian_users.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import puma.hope.librarian_users.exception.ValidationErrorResponseCustom;
import puma.hope.librarian_users.model.User;
import puma.hope.librarian_users.servise.FriendshipService;
import puma.hope.librarian_users.servise.UserService;

import java.util.List;

@RestController
@Tag(name = "Users", description = "Requests for users")
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/users")
public class UserController {
    UserService userService;
    FriendshipService friendshipService;
    //BookService bookService;


    public UserController(@Qualifier("userServiceJPAImpl") UserService userService, FriendshipService friendshipService) {
        this.userService = userService;
        this.friendshipService = friendshipService;
    }

    @PostMapping
    @Operation(summary = "Create user")
    public User create(@Valid @RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    @Operation(summary = "Update a user")
    public User update(@Valid @RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping
    @Operation(summary = "Find all users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {@Content(schema = @Schema(implementation = ValidationErrorResponseCustom.class), mediaType = "application/json")})
    })
    public User findUserById(@PathVariable("id") @Positive Long id) {
        return userService.findUserById(id);
    }

    @PutMapping("/{id}/friends/{friendId}")
    @Operation(summary = "Add a new friend")
    public User addFriend(@PathVariable("id") @Positive Long userId,
                          @PathVariable("friendId") Long friendId) {
        return friendshipService.addFriend(userId, friendId);
    }

    @DeleteMapping("/{id}/friends/{friendId}")
    @Operation(summary = "Remove from friends list")
    public User removeFriend(@PathVariable("id") @Positive Long userId,
                             @PathVariable("friendId") Long friendId) {
        return friendshipService.removeFriend(userId, friendId);
    }

    @GetMapping("{id}/friends")
    @Operation(summary = "Find user's friends")
    public List<User> findFriends(@PathVariable("id") @Positive Long userId) {
        return friendshipService.findFriends(userId);
    }

    @GetMapping("{id}/friends/common/{otherId}")
    @Operation(summary = "Find common friends for two users")
    public List<User> findCommonFriends(@PathVariable("id") @Positive Long userId,
                                        @PathVariable("otherId") @Positive Long otherUserId) {
        return friendshipService.findCommonFriends(userId, otherUserId);
    }

/*
    @GetMapping("/{id}/recommendations")
    @Operation(summary = "Recommend books by comparing user's likes to friend's likes")
    public List<Book> recommendBooks(@PathVariable(value = "id") Long userId) {
        return bookService.getRecommendBooks(userId);
    }
*/
}
