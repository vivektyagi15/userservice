package org.example.userservice.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.userservice.models.Role;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@JsonDeserialize(as = CustomSpringGrantedAuthority.class)
@NoArgsConstructor
public class CustomSpringGrantedAuthority implements GrantedAuthority {
    private Role role;

    public CustomSpringGrantedAuthority(Role role) {
        this.role = role;
    }

    @Override
    @JsonIgnore
    public String getAuthority() {
        return role.getRole();
    }
}