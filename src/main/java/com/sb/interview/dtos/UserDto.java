package com.sb.interview.dtos;

import com.sb.interview.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {
    private String name;
    private String login;
    private LocalDateTime localDateTime;

    public UserDto(User user) {
        this.login = user.getLogin();
        this.name = user.getName();
        this.localDateTime = user.getCreatedAt();
    }
}
