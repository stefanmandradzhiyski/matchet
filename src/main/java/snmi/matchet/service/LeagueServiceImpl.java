package snmi.matchet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snmi.matchet.entity.League;
import snmi.matchet.exception.LeagueNotFoundException;
import snmi.matchet.repository.LeagueRepository;

import java.util.List;

/**
 * League service implementation which implement the league service interface
 * and override all his methods
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
@Service
public class LeagueServiceImpl implements LeagueService {

    /**
     * League repository
     */
    private LeagueRepository leagueRepository;

    /**
     * Auto wire league repository through constructor
     * @param leagueRepository take the league repository
     */
    @Autowired
    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    /**
     * Creating league using the league repository
     * @param league take the league entity
     * @return the created league
     */
    @Override
    public League create(League league) {
        return leagueRepository.saveAndFlush(league);
    }

    /**
     * Reading specific league using the league repository
     * @param id take the id
     * @return the found league
     */
    @Override
    public League read(Long id) {
        return leagueRepository.findById(id).orElseThrow(() -> new LeagueNotFoundException(id));
    }

    /**
     * Reading all leagues using the league repository
     * @return the leagues list
     */
    @Override
    public List<League> readAll() {
        return leagueRepository.findAll();
    }

    /**
     * Updating existing league using the league repository
     * @param league take the league
     * @return the updated league
     */
    @Override
    public League update(League league) {
        return leagueRepository.saveAndFlush(league);
    }

    /**
     * Deleting existing league using the league repository
     * @param id take the id
     * @return the action result
     */
    @Override
    public boolean delete(Long id) {
        League league = read(id);
        if (league != null) {
            leagueRepository.deleteById(league.getId());
            return true;
        }

        return false;
    }

}
