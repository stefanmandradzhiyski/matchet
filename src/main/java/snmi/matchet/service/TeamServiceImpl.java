package snmi.matchet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snmi.matchet.entity.Team;
import snmi.matchet.exception.TeamNotFoundException;
import snmi.matchet.repository.TeamRepository;

import java.util.List;

/**
 * Team service implementation which implement the team service interface
 * and override all his methods
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
@Service
public class TeamServiceImpl implements TeamService {

    /**
     * Team repository
     */
    private TeamRepository teamRepository;

    /**
     * Auto wire team repository through constructor
     * @param teamRepository take the team repository
     */
    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    /**
     * Creating team using the team repository
     * @param team take the team entity
     * @return the created team
     */
    @Override
    public Team create(Team team) {
        return teamRepository.saveAndFlush(team);
    }

    /**
     * Reading specific team using the team repository
     * @param id take the id
     * @return the found team
     */
    @Override
    public Team read(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

    /**
     * Reading all teams using the team repository
     * @return the teams list
     */
    @Override
    public List<Team> readAll() {
        return teamRepository.findAll();
    }

    /**
     * Reading all league's teams using team repository
     * @param leagueId take the league id
     * @return the league's teams
     */
    @Override
    public List<Team> readAllLeagueTeams(long leagueId) {
        return teamRepository.findByLeagueId(leagueId);
    }

    /**
     * Updating existing team using the team repository
     * @param team take the existing team
     * @return the updated team
     */
    @Override
    public Team update(Team team) {
        return teamRepository.saveAndFlush(team);
    }

    /**
     * Delete existing team using the team repository
     * @param id take the team id
     * @return the action result
     */
    @Override
    public boolean delete(Long id) {
        Team team = read(id);
        if (team != null) {
            teamRepository.deleteById(team.getId());
            return true;
        }

        return false;
    }

}
