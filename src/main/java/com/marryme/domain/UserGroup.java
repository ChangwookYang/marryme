package com.marryme.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;         // 회원 id

    private Long name;       // 그룹명

    private LocalDateTime createdAt;   // 생성일시
    private String createdBy;          // 생성자
}
