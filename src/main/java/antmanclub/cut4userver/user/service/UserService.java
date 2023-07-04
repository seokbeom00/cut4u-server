package antmanclub.cut4userver.user.service;

import antmanclub.cut4userver.user.domain.User;
import antmanclub.cut4userver.user.dto.JoinDto;
import antmanclub.cut4userver.user.dto.LoginDto;
import antmanclub.cut4userver.user.dto.UserDto;

import java.util.Optional;

public interface UserService {
    UserDto join(JoinDto joinDto);
    UserDto login(LoginDto loginDto);
    Optional<User> findOne(String name);
}
