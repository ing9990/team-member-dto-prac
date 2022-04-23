package com.example.dtoprac.controller;

import com.example.dtoprac.domain.Team;
import com.example.dtoprac.dto.JoinTeamDto;
import com.example.dtoprac.dto.LeaveTeamDto;
import com.example.dtoprac.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TaeWK
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Controller {

    private final MainService mainService;

    @PostMapping("/join")
    public List<Team> joinMembers(@RequestBody JoinTeamDto joinTeamDto){
        return mainService.addMemberByTeamId(joinTeamDto.getMember_id(),joinTeamDto.getTeam_name());
    }


    @DeleteMapping("/leave")
    public List<Team> leaveMembers(@RequestBody LeaveTeamDto leaveTeamDto){
        return mainService.leave(leaveTeamDto);
    }
}

