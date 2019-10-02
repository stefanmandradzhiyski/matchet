package snmi.matchet.service;

import snmi.matchet.entity.Team;
import java.util.List;

/**
 * Team service interface
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public interface TeamService {

    /**
     * Need to be override to create a team using entity
     * @param team take the team entity
     * @return the created team
     */
    Team create(Team team);

    /**
     * Need to be override to read specific team by id
     * @param id take the id
     * @return the found team
     */
    Team read(Long id);

    /**
     * Need to be override to read all teams
     * @return the teams list
     */
    List<Team> readAll();

    /**
     * Need to be override to read all league's teams
     * @param leagueId take the league id
     * @return the league's teams
     */
    List<Team> readAllLeagueTeams(long leagueId);

    /**
     * Need to be override to update existing team
     * @param team take the team
     * @return the updated team
     */
    Team update(Team team);

    /**
     * Need to be override to delete specific team
     * @param id take the id
     * @return the action result
     */
    boolean delete(Long id);

}
