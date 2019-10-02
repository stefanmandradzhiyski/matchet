package snmi.matchet.dto;

import java.util.Date;

/**
 * Match presentation data transfer object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class MatchPresentationDto {

    /**
     * Match variables
     */
    private Long id;
    private Long leagueId;
    private String leagueName;
    private Long homeTeamId;
    private String homeTeamName;
    private Long awayTeamId;
    private String awayTeamName;
    private Date matchDate;
    private int matchHour;
    private int matchMinutes;
    private int homeTeamGoals;
    private int awayTeamGoals;

    /**
     * Default constructor
     */
    public MatchPresentationDto() {}

    /**
     * Custom constructor
     * @param id take the match's id
     * @param leagueId take the match's league id
     * @param leagueName take the match's league name
     * @param homeTeamId take the match's home team id
     * @param homeTeamName take the match's home team name
     * @param awayTeamId take the match's away team id
     * @param awayTeamName take the match's away team name
     * @param matchDate take the match's starting date
     * @param matchHour take the match's starting hour
     * @param matchMinutes take the match's starting minutes
     * @param homeTeamGoals take the match's home team goals
     * @param awayTeamGoals take the match's away team goals
     */
    public MatchPresentationDto(Long id, Long leagueId, String leagueName, Long homeTeamId, String homeTeamName,
                                Long awayTeamId, String awayTeamName, Date matchDate, int matchHour, int matchMinutes,
                                int homeTeamGoals, int awayTeamGoals) {
        this.id = id;
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.homeTeamId = homeTeamId;
        this.homeTeamName = homeTeamName;
        this.awayTeamId = awayTeamId;
        this.awayTeamName = awayTeamName;
        this.matchDate = matchDate;
        this.matchHour = matchHour;
        this.matchMinutes = matchMinutes;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
    }

    /**
     * Getters and setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Long getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public Long getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(Long awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public int getMatchHour() {
        return matchHour;
    }

    public void setMatchHour(int matchHour) {
        this.matchHour = matchHour;
    }

    public int getMatchMinutes() {
        return matchMinutes;
    }

    public void setMatchMinutes(int matchMinutes) {
        this.matchMinutes = matchMinutes;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }
}
