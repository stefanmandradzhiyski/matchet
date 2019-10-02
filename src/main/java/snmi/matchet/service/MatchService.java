package snmi.matchet.service;

import snmi.matchet.entity.Match;
import java.util.List;

/**
 * Match service interface
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public interface MatchService {

    /**
     * Need to be override to create a match using entity
     * @param match take the match entity
     * @return the created match
     */
    Match create(Match match);

    /**
     * Need to be override to read specific match by id
     * @param id take the id
     * @return the found match
     */
    Match read(Long id);

    /**
     * Need to be override to read all matches
     * @return the matches list
     */
    List<Match> readAll();

    /**
     * Need to be override to read all matches for specific league
     * @param leagueId take the league id
     * @return the league's matches list
     */
    List<Match> readAllLeagueMatches(long leagueId);

    /**
     * Need to be override to read all home team matches
     * @param homeTeamId take the home team id
     * @return the home team matches list
     */
    List<Match> readAllHomeTeamMatches(long homeTeamId);

    /**
     * Need to be override to read all away team matches
     * @param awayTeamId take the away team id
     * @return the away team matches list
     */
    List<Match> readAllAwayTeamMatches(long awayTeamId);

    /**
     * Need to be override to update existing match
     * @param match take the existing match
     * @return the updated match
     */
    Match update(Match match);

    /**
     * Need to be override to delete existing match
     * @param id take the match id
     * @return the action result
     */
    boolean delete(Long id);

}
