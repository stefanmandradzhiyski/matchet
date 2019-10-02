package snmi.matchet.service;

import snmi.matchet.entity.League;
import java.util.List;

/**
 * League service interface
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public interface LeagueService {

    /**
     * Need to be override to create a league using entity
     * @param league take the league entity
     * @return the created league
     */
    League create(League league);

    /**
     * Need to be override to read specific league by id
     * @param id take the id
     * @return the found league
     */
    League read(Long id);

    /**
     * Need to be override to read all leagues
     * @return the leagues list
     */
    List<League> readAll();

    /**
     * Need to be override to update existing league
     * @param league take the league
     * @return the updated league
     */
    League update(League league);

    /**
     * Need to be override to delete specific league
     * @param id take the id
     * @return the action result
     */
    boolean delete(Long id);

}
