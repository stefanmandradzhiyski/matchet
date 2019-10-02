package snmi.matchet.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * League entity (POJO)
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
@Entity
@Table(name = "leagues")
public class League {

    /**
     * Identity league id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * League name
     */
    @Column(name = "name", columnDefinition = "varchar(30) not null")
    private String name;

    /**
     * League short description
     */
    @Column(name = "short_description", columnDefinition = "varchar(255) not null")
    private String shortDescription;

    /**
     * Bi-directional relationship with teams
     */
    @OneToMany(mappedBy = "league", fetch = FetchType.LAZY)
    private List<Team> teams = new ArrayList<>();

    /**
     * Bi-directional relationship with matches
     */
    @OneToMany(mappedBy = "league", fetch = FetchType.LAZY)
    private List<Match> matches = new ArrayList<>();

    /**
     * Default constructor
     */
    public League() {}

    /**
     * Custom constructor
     * @param id take the league's id
     * @param name take the league's name
     * @param shortDescription take the league's short description
     * @param teams take the league's teams
     * @param matches take the league's matches
     */
    public League(Long id, String name, String shortDescription, List<Team> teams, List<Match> matches) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.teams = teams;
        this.matches = matches;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
