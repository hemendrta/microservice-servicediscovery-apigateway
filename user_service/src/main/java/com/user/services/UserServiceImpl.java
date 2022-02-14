package com.user.services;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users=List.of(
            new User(1344l, "Demo User", "7999996892"),
            new User(1343l,"Test User","7999996893"),
            new User(1341l,"Demo Test User", "7999996895")
    );

    @Override
    public User getUser(Long userId) {
        return users.stream().filter(user -> user.getUserId().equals(userId)).findAny().orElse(null);
    }
}
