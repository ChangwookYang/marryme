package com.marryme.repository;

import com.marryme.AbstractIntegrationContainerBaseTest;
import com.marryme.domain.Plan;
import com.marryme.domain.PlanComment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlanCommentRepositoryTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    PlanRepository planRepository;

    @Autowired
    PlanCommentRepository planCommentRepository;

    @BeforeEach
    void setUp() {
        Plan plan = Plan.builder()
                .title("테스트 제목")
                .content("테스트 콘텐츠")
                .hashtag("해시태그")
                .createdAt(LocalDateTime.now())
                .createdBy("cw")
                .modifiedAt(LocalDateTime.now())
                .modifiedBy("cw")
                .build();

        Plan savedPlan = planRepository.save(plan);

        planCommentRepository.save(
                PlanComment.builder()
                        .plan(savedPlan)
                        .content("테스트 Plan Comment")
                        .createdAt(LocalDateTime.now())
                        .createdBy("cw")
                        .modifiedAt(LocalDateTime.now())
                        .modifiedBy("cw")
                        .build()
        );
    }

    @Test
    @Transactional
    void findAll() {
        List<PlanComment> all = planCommentRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

}