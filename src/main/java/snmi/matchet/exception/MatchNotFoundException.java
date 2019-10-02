package snmi.matchet.exception;

import snmi.matchet.util.Constants;

/**
 * Match not found exception which extends Runtime Exception
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class MatchNotFoundException extends RuntimeException {

    /**
     * Constructor
     * @param id take the match's id
     */
    public MatchNotFoundException(Long id) {
        super(String.format(Constants.MATCH_NOT_FOUND, id));
    }

}
