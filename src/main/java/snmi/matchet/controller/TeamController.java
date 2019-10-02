package snmi.matchet.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snmi.matchet.dto.TeamMainDto;
import snmi.matchet.dto.TeamPresentationDto;
import snmi.matchet.entity.League;
import snmi.matchet.entity.Team;
import snmi.matchet.service.LeagueService;
import snmi.matchet.service.TeamService;
import snmi.matchet.util.Constants;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Team rest controller
 * Communicate with the view. team and league services
 * Using Model Mapper to transfer object from entity to dto or reverse dto to entity
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
@RestController
@RequestMapping(value = Constants.VERSION + Constants.TEAMS)
public class TeamController {

    /**
     * Services
     */
    private TeamService teamService;
    private LeagueService leagueService;

    /**
     * Model Mapper DTO
     */
    private ModelMapper modelMapper;

    /**
     * Auto wire team service, league service and model mapper through constructor
     * @param teamService take the team service
     * @param leagueService take the league service
     * @param modelMapper take the model mapper
     */
    @Autowired
    public TeamController(TeamService teamService, LeagueService leagueService, ModelMapper modelMapper) {
        this.teamService = teamService;
        this.leagueService = leagueService;
        this.modelMapper = modelMapper;
    }

    /**
     * Creating a team by POST request method with specific url and team n league services
     * @param teamMainDto take the team dto
     * @return the created team dto
     */
    @PostMapping
    public TeamMainDto create(@RequestBody @Valid TeamMainDto teamMainDto) {
        Team team = modelMapper.map(teamMainDto, Team.class);
        League league = leagueService.read(teamMainDto.getLeagueId());
        team.setLeague(league);
        teamService.create(team);
        return teamMainDto;
    }

    /**
     * Reading specific team by GET request method with specific url using team service
     * @param id take the team id
     * @return the found team
     */
    @GetMapping(value = "/{id}")
    public TeamPresentationDto read(@PathVariable Long id) {
        Team foundTeam = teamService.read(id);
        return modelMapper.map(foundTeam, TeamPresentationDto.class);
    }

    /**
     * Reading all available teams by GET request method with specific url using team service
     * @return the teams dto list
     */
    @GetMapping
    public List<TeamPresentationDto> readAllTeams() {
        List<TeamPresentationDto> teamPresentationDtos = new ArrayList<>();
        List<Team> teams = teamService.readAll();
        for (Team team : teams) {
            teamPresentationDtos.add(modelMapper.map(team, TeamPresentationDto.class));
        }

        return teamPresentationDtos;
    }

    /**
     * Reading all league's teams by GET request method with specific url using team service and
     * custom repository query
     * @param id take the league id
     * @return all league's teams list
     */
    @GetMapping(value = "-by-league/{id}")
    public List<TeamPresentationDto> readAllLeagueTeams(@PathVariable Long id) {
        List<TeamPresentationDto> teamPresentationDtos = new ArrayList<>();
        List<Team> teams = teamService.readAllLeagueTeams(id);
        for (Team team : teams) {
            teamPresentationDtos.add(modelMapper.map(team, TeamPresentationDto.class));
        }

        return teamPresentationDtos;
    }

    /**
     * Updating existing team by PUT request method with specific url and team service
     * @param teamMainDto take the new team dto data
     * @param id take the team id which we want to update
     * @return the updated team dto
     */
    @PutMapping(value = "/{id}")
    public TeamMainDto update(@RequestBody @Valid TeamMainDto teamMainDto, @PathVariable Long id) {
        teamMainDto.setId(id);
        Team team = modelMapper.map(teamMainDto, Team.class);
        Team existingTeam = teamService.read(id);
        BeanUtils.copyProperties(team, existingTeam);
        teamService.update(existingTeam);
        return teamMainDto;
    }

    /**
     * Deleting existing team by DELETE request method with specific url and team service
     * @param id take the team id which we want to delete
     * @return the delete result
     */
    @DeleteMapping(value = "/{id}")
    public boolean delete(@PathVariable Long id) {
        return teamService.delete(id);
    }

}
