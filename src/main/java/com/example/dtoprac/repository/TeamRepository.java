package com.example.dtoprac.repository;

import com.example.dtoprac.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author TaeWK
 */

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
    Team findTeamByName(String name);
}
