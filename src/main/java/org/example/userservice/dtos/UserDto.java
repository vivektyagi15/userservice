package org.example.userservice.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.userservice.models.Role;
import org.example.userservice.models.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDto {
    private String email;
    private List<Role> roles = new ArrayList<>();

    public UserDto (User user) {
        this.email = user.getEmail();
        this.roles = user.getRoles();
    }

    public UserDto() {
    }
}
