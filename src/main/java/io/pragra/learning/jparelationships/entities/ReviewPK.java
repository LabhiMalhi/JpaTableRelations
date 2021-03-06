package io.pragra.learning.jparelationships.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ReviewPK implements Serializable {
    @Column
    private Integer courseId;
    @Column
    private Integer reviewId;
}
