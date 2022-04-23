package com.example.dtoprac.controller;

import com.example.dtoprac.domain.Team;
import com.example.dtoprac.dto.PostTeamDto;
import com.example.dtoprac.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TaeWK
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team")
@Slf4j
public class TeamController {

    private final TeamService teamService;

    @GetMapping()
    public List<Team> getTeamAll(){
        return teamService.findTeamAll();
    }

    @GetMapping("/{name}")
    public Team getTeamByName(@PathVariable String name){
        return teamService.findTeamByName(name);
    }

    @PostMapping()
    public List<Team> addTeam(@RequestBody PostTeamDto postTeamDto){
        return teamService.addTeam(postTeamDto);
    }
}
