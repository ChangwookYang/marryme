package com.marryme.dto.security;

import com.marryme.dto.UserDto;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public record PlanPrincipal(
        Long userId,
        Long userGroupId,
        String nickname,
        Collection<? extends GrantedAuthority> authorities
) implements UserDetails {

    public static PlanPrincipal of(Long userId, Long userGroupId, String nickname) {
        Set<RoleType> roleTypes = Set.of(RoleType.USER);
        return new PlanPrincipal(
                userId,
                userGroupId,
                nickname,
                roleTypes.stream()
                        .map(RoleType::getName)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toUnmodifiableSet()));
    }

    public static PlanPrincipal from(UserDto dto) {
        return PlanPrincipal.of(dto.getUserId(), dto.getUserGroupId(), dto.getNickname());
    }

    public UserDto toDto() {
        return UserDto.of(userId, userGroupId, nickname);
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }

    @Override public String getUsername() { return String.valueOf(userId); }
    @Override public String getPassword() { return String.valueOf(userGroupId); }

    @Override public boolean isAccountNonExpired() { return false; }
    @Override public boolean isAccountNonLocked() { return false; }
    @Override public boolean isCredentialsNonExpired() { return false; }
    @Override public boolean isEnabled() { return false; }

    public enum RoleType {
        USER("ROLE_USER");

        @Getter
        private final String name;

        RoleType(String name) {
            this.name = name;
        }
    }
}
