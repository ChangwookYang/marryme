package com.marryme.domain;

import java.time.LocalDateTime;

public class Plan {
    private Long id;            // 계획 id
    private String title;       // 계획명
    private String content;     // 계획내용
    private String hashtag;     // 해시태그

    private LocalDateTime createdAt;   // 생성일시
    private String createdBy;          // 생성자
    private LocalDateTime modifiedAt;   // 수정일시
    private String modifiedBy;          // 수정자
}
