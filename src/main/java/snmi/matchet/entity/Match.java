package snmi.matchet.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Match entity (POJO)
 * @author Stefan Mandradzhyski
 * @version 1.0
 */
@Entity
@Table(name = "matches")
public class Match {

    /**
     * Identity match id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Match league
     */
    @ManyToOne
    @JoinColumn(name = "league_id", columnDefinition = "int(11) not null")
    private League league;

    /**
     * Match home team
     */
    @ManyToOne
    @JoinColumn(name = "home_team_id", columnDefinition = "int(11) not null")
    private Team homeTeam;

    /**
     * Match away team
     */
    @ManyToOne
    @JoinColumn(name = "away_team_id", columnDefinition = "int(11) not null")
    private Team awayTeam;

    /**
     * Match date
     */
    @Column(name = "match_date", columnDefinition = "date not null")
    private Date matchDate;

    /**
     * Match starting hour
     */
    @Column(name = "match_hour", columnDefinition = "int(2) not null")
    private int matchHour;

    /**
     * Match starting minutes
     */
    @Column(name = "match_minutes", columnDefinition = "int(2) not null")
    private int matchMinutes;

    /**
     * Match home team goals
     */
    @Column(name = "home_team_goals", columnDefinition = "int(2) not null")
    private int homeTeamGoals;

    /**
     * Match away team goals
     */
    @Column(name = "away_team_goals", columnDefinition = "int(2) not null")
    private int awayTeamGoals;

    /**
     * Default constructor
     */
    public Match() {}

    /**
     * Custom constructor
     * @param id take the match's id
     * @param league take the match's league
     * @param homeTeam take the match's home team
     * @param awayTeam take the match's away team
     * @param matchDate take the match's starting date
     * @param matchHour take the match's starting hour
     * @param matchMinutes take the match's starting minutes
     * @param homeTeamGoals take the match's home team goals
     * @param awayTeamGoals take the match's away team goals
     */
    public Match(Long id, League league, Team homeTeam, Team awayTeam, Date matchDate, int matchHour, int matchMinutes, int homeTeamGoals, int awayTeamGoals) {
        this.id = id;
        this.league = league;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
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

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
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
