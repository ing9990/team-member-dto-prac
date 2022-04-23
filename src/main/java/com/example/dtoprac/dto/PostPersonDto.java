package com.example.dtoprac.dto;

import com.example.dtoprac.domain.Gender;
import lombok.Getter;
import lombok.Setter;

/**
 * @author TaeWK
 */

@Getter
@Setter
public class PostPersonDto {
    private String name;
    private int age;
    private Gender gender;
}
