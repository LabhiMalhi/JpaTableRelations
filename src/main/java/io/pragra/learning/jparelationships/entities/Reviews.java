package io.pragra.learning.jparelationships.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Reviews {

    @EmbeddedId

   private ReviewPK reviewPK;

    private String programName;

    private String reviewText;

    @ManyToOne
    private Student student;
}
