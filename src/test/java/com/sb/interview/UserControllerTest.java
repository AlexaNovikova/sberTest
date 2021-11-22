package com.sb.interview;

import com.sb.interview.dtos.UserDto;
import com.sb.interview.models.User;
import com.sb.interview.repositories.UserRepository;
import com.sb.interview.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUsersPerPage() {
        List<User> users = Arrays.asList(new User("user", "123", "bob"),
                new User("admin", "1234", "john"),
                new User("user2", "123123", "pol"),
                new User("admin2", "1234", "tom"),
                new User("user3", "afadsf", "sam"),
                new User("user4", "1asdfa", "koul"),
                new User("user5", "fkhjk", "lu"),
                new User("user6", "1sgsdfg", "nap"));

        Page<User> userPageMock = new PageImpl<>(users);

            Mockito.doReturn(userPageMock)
                .when(userRepository)
                .findAll(PageRequest.of(0,20));

        Page<UserDto> userPage = userService.findAll(1, 20);
        Assertions.assertNotNull(userPage);
        Assertions.assertEquals(userPage, new PageImpl<>(users.stream().map(UserDto::new).collect(Collectors.toList())));
    }
}
