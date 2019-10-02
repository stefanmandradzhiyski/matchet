package snmi.matchet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snmi.matchet.entity.Match;
import snmi.matchet.exception.MatchNotFoundException;
import snmi.matchet.repository.MatchRepository;

import java.util.List;

/**
 * Match service implementation which implement the match service interface
 * and override all his methods
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
@Service
public class MatchServiceImpl implements MatchService{

    /**
     * Match repository
     */
    private MatchRepository matchRepository;

    /**
     * Auto wire match repository through constructor
     * @param matchRepository take the match repository
     */
    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    /**
     * Creating match using the match repository
     * @param match take the match entity
     * @return the created match
     */
    @Override
    public Match create(Match match) {
        return matchRepository.saveAndFlush(match);
    }

    /**
     * Reading specific match using the match repository
     * @param id take the id
     * @return the found match
     */
    @Override
    public Match read(Long id) {
        return matchRepository.findById(id).orElseThrow(() -> new MatchNotFoundException(id));
    }

    /**
     * Reading all matches using the match repository
     * @return the matches list
     */
    @Override
    public List<Match> readAll() {
        return matchRepository.findAll();
    }

    /**
     * Reading all league's matches using the match repository
     * @param leagueId take the league id
     * @return the league's matches list
     */
    @Override
    public List<Match> readAllLeagueMatches(long leagueId) {
        return matchRepository.findByLeagueId(leagueId);
    }

    /**
     * Reading all home team matches using the match repository
     * @param homeTeamId take the home team id
     * @return the home team matches
     */
    @Override
    public List<Match> readAllHomeTeamMatches(long homeTeamId) {
        return matchRepository.findByHomeTeamId(homeTeamId);
    }

    /**
     * Reading all away team matches using the match repository
     * @param awayTeamId take the away team id
     * @return the away team matches
     */
    @Override
    public List<Match> readAllAwayTeamMatches(long awayTeamId) {
        return matchRepository.findByAwayTeamId(awayTeamId);
    }

    /**
     * Updating existing match using the match repository
     * @param match take the existing match
     * @return the updated match
     */
    @Override
    public Match update(Match match) {
        return matchRepository.saveAndFlush(match);
    }

    /**
     * Delete existing match using the match repository
     * @param id take the match id
     * @return the action result
     */
    @Override
    public boolean delete(Long id) {
        Match match = read(id);
        if (match != null) {
            matchRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
