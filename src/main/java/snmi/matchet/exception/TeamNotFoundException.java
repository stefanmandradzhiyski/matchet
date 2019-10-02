package snmi.matchet.exception;

import snmi.matchet.util.Constants;

/**
 * Team not found exception which extends Runtime Exception
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class TeamNotFoundException extends RuntimeException {

    /**
     * Constructor
     * @param id take the team's id
     */
    public TeamNotFoundException(Long id) {
        super(String.format(Constants.TEAM_NOT_FOUND, id));
    }

}
