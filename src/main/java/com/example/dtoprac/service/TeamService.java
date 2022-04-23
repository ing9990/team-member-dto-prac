package com.example.dtoprac.service;

import com.example.dtoprac.domain.Members;
import com.example.dtoprac.domain.Team;
import com.example.dtoprac.dto.PostTeamDto;
import com.example.dtoprac.repository.MembersRepository;
import com.example.dtoprac.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author TaeWK
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {

    private final TeamRepository teamRepository;


    public List<Team> findTeamAll() {
        return teamRepository.findAll();
    }

    public List<Team> addTeam(PostTeamDto postTeamDto) {

        if (teamRepository.findAll().stream().anyMatch((x) -> x.getName().equals(postTeamDto.getName()))) {
            log.info(postTeamDto.getName() + "팀은 이미 있습니다.");
        } else {

            Team t = new Team();
            t.setName(postTeamDto.getName());
            teamRepository.save(t);
            log.info(t.getName() + "팀이 성공적으로 생성되었습니다.");
        }
        return teamRepository.findAll();
    }

    public Team findTeamByName(String name) {
        return teamRepository.findTeamByName(name);
    }
}
