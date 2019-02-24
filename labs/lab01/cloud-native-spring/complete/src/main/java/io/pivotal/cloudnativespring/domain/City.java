package io.pivotal.cloudnativespring.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String county;

    @NonNull
    private String stateCode;

    @NonNull
    private String postalCode;

    private String latitude;

    private String longitude;

}
