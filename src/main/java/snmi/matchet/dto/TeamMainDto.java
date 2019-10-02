package snmi.matchet.dto;

import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Team data transfer object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class TeamMainDto {

    /**
     * Team id
     */
    private Long id;

    /**
     * Team name
     */
    @NotNull(message = "{validation.team.name.notNull}")
    @Size(min = 3, max = 30, message = "{validation.team.name.size}")
    private String name;

    /**
     * Team short name
     */
    @NotNull(message = "{validation.team.short.name.notNull}")
    @Size(min = 1, max = 3, message = "{validation.team.short.name.size}")
    private String shortName;

    /**
     * Team league
     */
    @JoinColumn(name = "league_id", columnDefinition = "int(11) not null")
    @NotNull(message = "{validation.team.league.notNull}")
    private Long leagueId;

    /**
     * Default constructor
     */
    public TeamMainDto() {}

    /**
     * Custom constructor
     * @param id take the team's id
     * @param name take the team's name
     * @param shortName take the team's short name
     * @param leagueId take the team's league
     */
    public TeamMainDto(Long id, String name, String shortName, Long leagueId) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.leagueId = leagueId;
    }

    /**
     * Getters and setters
     * @return
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

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }
}
