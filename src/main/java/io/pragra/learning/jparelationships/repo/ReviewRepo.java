package io.pragra.learning.jparelationships.repo;

import io.pragra.learning.jparelationships.entities.ReviewPK;
import io.pragra.learning.jparelationships.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Reviews, ReviewPK> {
}
