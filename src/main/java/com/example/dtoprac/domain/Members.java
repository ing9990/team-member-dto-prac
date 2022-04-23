package com.example.dtoprac.domain;

import lombok.*;
import javax.persistence.*;

/**
 * @author TaeWK
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBERS_ID")
    private Long id;

    @Column(name = "MEMBERS_NAME")
    private String name;

    @Column(name = "MEMBERS_AGE")
    @NonNull
    private int age;

    @Column(name = "MEMBERS_GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.NOT_SELECTED;









}
