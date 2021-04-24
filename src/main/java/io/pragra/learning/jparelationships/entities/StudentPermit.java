package io.pragra.learning.jparelationships.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class StudentPermit {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 50)
    private String permitName;

}
