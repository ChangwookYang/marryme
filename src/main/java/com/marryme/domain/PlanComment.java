package com.marryme.domain;

import java.time.LocalDateTime;

public class PlanComment {
    private Long id;        // 댓글 ID
    private Plan plan;      // 계획 ID
    private String content; // 댓글 내용

    private LocalDateTime createdAt;   // 생성일시
    private String createdBy;          // 생성자
    private LocalDateTime modifiedAt;   // 수정일시
    private String modifiedBy;          // 수정자
}