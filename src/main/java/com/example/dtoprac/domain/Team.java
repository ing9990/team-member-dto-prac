package com.example.dtoprac.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TaeWK
 */

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Slf4j
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private Long id;


    @Column(name = "TEAM_NAME")
    @NonNull
    private String name;


    @OneToMany
    private List<Members> members = new ArrayList<>();


    public void addMembers(Members member){
        members.add(member);
    }
    public void deleteMembers(Members member){
        members.remove(member);
    }
}
