package snmi.matchet.exception;

import snmi.matchet.util.Constants;

/**
 * League not found exception which extends Runtime Exception
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class LeagueNotFoundException extends RuntimeException {

    /**
     * Constructor
     * @param id take the league's id
     */
    public LeagueNotFoundException(Long id) {
        super(String.format(Constants.LEAGUE_NOT_FOUND, id));
    }

}
