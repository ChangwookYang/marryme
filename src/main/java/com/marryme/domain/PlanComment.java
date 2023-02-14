package com.marryme.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity(name ="plan_comment")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        // 댓글 ID

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;      // 계획 ID
    private String content; // 댓글 내용

    private LocalDateTime createdAt;   // 생성일시
    private String createdBy;          // 생성자
    private LocalDateTime modifiedAt;   // 수정일시
    private String modifiedBy;          // 수정자
}