package com.sb.interview.services;

import com.sb.interview.dtos.UserDto;
import com.sb.interview.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserRepository userRepository;

    public Page<UserDto> findAll(int page, int pageSize) {
       return userRepository.findAll(PageRequest.of(page - 1, pageSize)).map(UserDto::new);
    }

}