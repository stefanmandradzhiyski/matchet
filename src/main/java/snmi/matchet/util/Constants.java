package snmi.matchet.util;

/**
 * Constants util which hold all application constants
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class Constants {

    /**
     * Application constants
     */
    public static final String VERSION = "/v1/api/";
    public static final String LEAGUES = "leagues";
    public static final String TEAMS = "teams";
    public static final String MATCHES = "matches";
    public static final String LEAGUE_NOT_FOUND = "League with id %s not found in the database!";
    public static final String TEAM_NOT_FOUND = "Team with id %s not found in the database!";
    public static final String MATCH_NOT_FOUND = "Match with id %s not found in the database!";

    /**
     * Default constructor
     */
    private Constants() {}

}
