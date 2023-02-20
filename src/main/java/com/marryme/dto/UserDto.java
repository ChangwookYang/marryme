package com.marryme.dto;

import com.marryme.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    Long userId;
    Long userGroupId;
    String nickname;


    public static UserDto from(User user) {
        return UserDto.of(user.getId(), user.getUserGroupId(), user.getNickname());
    }

    public static UserDto of(Long userId, Long userGroupId, String nickname) {
        return new UserDto(
                userId,
                userGroupId,
                nickname);
    }
}
