package com.example.users.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Data
public class UserVo {

    private final Integer        userId;
    private final String         username;
    private final String         password;
    private final String         salt;
    private final String         firstname;
    private final String         lastname;
    private final String         email;
    private final Short          status;
    private final OffsetDateTime createdon;
    private final Long           mobile;
    private final OffsetDateTime changedon;
}
