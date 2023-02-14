package com.marryme.repository;

import com.marryme.AbstractIntegrationContainerBaseTest;
import com.marryme.domain.Plan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class PlanRepositoryTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private PlanRepository planRepository;

    @Test
    void savePlan() {
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

        assertThat(savedPlan.getTitle()).isEqualTo(plan.getTitle());
    }
}