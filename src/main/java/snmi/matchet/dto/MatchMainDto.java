package snmi.matchet.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Match data transfer object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class MatchMainDto {

    /**
     * Match id
     */
    private Long id;

    /**
     * Match league
     */
    @NotNull(message = "{validation.match.league.notNull}")
    private Long leagueId;

    /**
     * Match home team
     */
    @NotNull(message = "{validation.match.home.team.notNull}")
    private Long homeTeamId;

    /**
     * Match away team
     */
    @NotNull(message = "{validation.match.away.team.notNull}")
    private Long awayTeamId;

    /**
     * Match starting date
     */
    @NotNull(message = "{validation.match.date.notNull}")
    @DateTimeFormat(pattern = "dd-MMM-yyyy")
    @FutureOrPresent
    private Date matchDate;

    /**
     * Match starting hour
     */
    @Positive
    @Min(1)
    @Max(24)
    private int matchHour;

    /**
     * Match starting minutes
     */
    @PositiveOrZero
    @Min(0)
    @Max(60)
    private int matchMinutes;

    /**
     * Match home team goals
     */
    @PositiveOrZero
    @Min(0)
    @Max(99)
    private int homeTeamGoals;

    /**
     * Match away team goals
     */
    @PositiveOrZero
    @Min(0)
    @Max(99)
    private int awayTeamGoals;

    /**
     * Default constructor
     */
    public MatchMainDto() {}

    /**
     * Custom constructor
     * @param id take the match's id
     * @param leagueId take the match's league
     * @param homeTeamId take the match's home team
     * @param awayTeamId take the match's away team
     * @param matchDate take the match's starting date
     * @param matchHour take the match's starting hour
     * @param matchMinutes take the match's starting minutes
     * @param homeTeamGoals take the match's home team goals
     * @param awayTeamGoals take the match's away team goals
     */
    public MatchMainDto(Long id, Long leagueId, Long homeTeamId, Long awayTeamId, Date matchDate, int matchHour, int matchMinutes, int homeTeamGoals, int awayTeamGoals) {
        this.id = id;
        this.leagueId = leagueId;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
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

    public Long getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public Long getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(Long awayTeamId) {
        this.awayTeamId = awayTeamId;
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
