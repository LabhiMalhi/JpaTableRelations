package io.pragra.learning.jparelationships.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

public class Programs {

    @Id
    private Integer id;

    private String name;

    private Long duration;
}
