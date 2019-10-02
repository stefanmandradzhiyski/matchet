package snmi.matchet.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Team entity (POJO)
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
@Entity
@Table(name = "teams")
public class Team {

    /**
     * Identity team id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Team name
     */
    @Column(name = "name", columnDefinition = "varchar (30) not null")
    private String name;

    /**
     * Team short name
     */
    @Column(name = "short_name", columnDefinition = "varchar (3) not null")
    private String shortName;

    /**
     * Team league
     */
    @ManyToOne
    private League league;

    /**
     * Bi-directional relationship with home teams
     */
    @OneToMany(mappedBy = "homeTeam", fetch = FetchType.LAZY)
    private List<Match> homeTeams = new ArrayList<>();

    /**
     * Bi-directional relationship with away teams
     */
    @OneToMany(mappedBy = "awayTeam", fetch = FetchType.LAZY)
    private List<Match> awayTeams = new ArrayList<>();

    /**
     * Default constructor
     */
    public Team() {}

    /**
     * Custom constructor
     * @param id take the team's id
     * @param name take the team's name
     * @param shortName take the team's short name
     * @param league take the team's league
     * @param homeTeams take the team's home teams
     * @param awayTeams take the team's away teams
     */
    public Team(Long id, String name, String shortName, League league, List<Match> homeTeams, List<Match> awayTeams) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.league = league;
        this.homeTeams = homeTeams;
        this.awayTeams = awayTeams;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public List<Match> getHomeTeams() {
        return homeTeams;
    }

    public void setHomeTeams(List<Match> homeTeams) {
        this.homeTeams = homeTeams;
    }

    public List<Match> getAwayTeams() {
        return awayTeams;
    }

    public void setAwayTeams(List<Match> awayTeams) {
        this.awayTeams = awayTeams;
    }
}
