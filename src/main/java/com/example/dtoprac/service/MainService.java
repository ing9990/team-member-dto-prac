package com.example.dtoprac.service;

import com.example.dtoprac.domain.Members;
import com.example.dtoprac.domain.Team;
import com.example.dtoprac.dto.LeaveTeamDto;
import com.example.dtoprac.repository.MembersRepository;
import com.example.dtoprac.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TaeWK
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {

    private final MembersRepository membersRepository;
    private final TeamRepository teamRepository;


    public List<Team> addMemberByTeamId(Long member_id, String team_name) {

        Team team = teamRepository.findTeamByName(team_name);

        if(team == null){
            log.info("팀 이름이 존재하지 않습니다. [" + team_name + "]");
        }else {

            Members members = membersRepository.findById(member_id)
                    .orElseThrow(() -> new RuntimeException("MEMBER ID NOT FOUND"));

            team.addMembers(members);
            teamRepository.save(team);

            log.info(members.getName() + "님이 " + team_name +"팀에 가입하셨습니다.");
        }
        return teamRepository.findAll();
    }

    public List<Team> leave(LeaveTeamDto leaveTeamDto) {

        Team team = teamRepository.findTeamByName(leaveTeamDto.getTeam_name());
        Members members = membersRepository.findById(leaveTeamDto.getMembers_id())
                .orElseThrow(RuntimeException::new);

        if(team == null){
            log.info(leaveTeamDto.getTeam_name()+"을 찾을 수 없습니다.");
        }else{

            teamRepository.findTeamByName(leaveTeamDto.getTeam_name())
                    .deleteMembers(members);

            teamRepository.flush();

            log.info(members.getName() +"님이 " + leaveTeamDto.getTeam_name() +"팀을 탈퇴하였습니다.");
        }
        return teamRepository.findAll();

    }
}
