package snmi.matchet.dto;

/**
 * Team presentation data transfer object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class TeamPresentationDto {

    /**
     * Team variable
     */
    private Long id;
    private String name;
    private String shortName;
    private Long leagueId;
    private String leagueName;

    /**
     * Default constructor
     */
    public TeamPresentationDto() {}

    /**
     * Custom constructor
     * @param id take the team id
     * @param name take the team name
     * @param shortName take the team short name
     * @param leagueId take the team league
     * @param leagueName take the team league name
     */
    public TeamPresentationDto(Long id, String name, String shortName, Long leagueId, String leagueName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.leagueId = leagueId;
        this.leagueName = leagueName;
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
}
