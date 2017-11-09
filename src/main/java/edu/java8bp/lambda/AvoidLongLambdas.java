package edu.java8bp.lambda;

import edu.java8bp.User;
import edu.java8bp.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class AvoidLongLambdas {

    // Ugly
    class LongLambdaInPlace {
        public List<UserDto> convertToDto(List<User> users) {
            return users.stream()
                    .map(u -> {
                        UserDto dto = new UserDto();
                        dto.setId(u.getId());
                        dto.setName(u.getName());
                        return dto;
                    })
                    .collect(Collectors.toList());
        }
    }

    // Good
    class ExtractLogicToMethod {
        public List<UserDto> convertToDto(List<User> users) {
            return users.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }

        private UserDto convertToDto(User user) {
            UserDto dto = new UserDto();
            dto.setName(user.getName());
            dto.setId(user.getId());
            return dto;
        }
    }

}
