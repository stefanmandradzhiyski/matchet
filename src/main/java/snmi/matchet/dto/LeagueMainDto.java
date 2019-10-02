package snmi.matchet.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * League data transfer object
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class LeagueMainDto {

    /**
     * League id
     */
    private Long id;

    /**
     * League name
     */
    @NotNull(message = "{validation.league.name.notNull}")
    @Size(min = 3, max = 30, message = "{validation.league.name.size}")
    private String name;

    /**
     * League short description
     */
    @NotNull(message = "{validation.league.short.description.notNull}")
    @Size(min = 3, max = 255, message = "{validation.league.short.description.size}")
    private String shortDescription;

    /**
     * Default constructor
     */
    public LeagueMainDto() {}

    /**
     * Custom constructor
     * @param id take the league's id
     * @param name take the league's name
     * @param shortDescription take the league's short description
     */
    public LeagueMainDto(Long id, String name, String shortDescription) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
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
}
