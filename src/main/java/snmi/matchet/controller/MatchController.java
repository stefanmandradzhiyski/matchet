package snmi.matchet.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snmi.matchet.dto.MatchMainDto;
import snmi.matchet.dto.MatchPresentationDto;
import snmi.matchet.entity.League;
import snmi.matchet.entity.Match;
import snmi.matchet.entity.Team;
import snmi.matchet.service.LeagueService;
import snmi.matchet.service.MatchService;
import snmi.matchet.service.TeamService;
import snmi.matchet.util.Constants;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Match rest controller
 * Communicate with the view, match, team and league services
 * Using Model Mapper to transfer object from entity to dto or reverse dto to entity
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
@RestController
@RequestMapping(value = Constants.VERSION + Constants.MATCHES)
public class MatchController {

    /**
     * Services
     */
    private MatchService matchService;
    private LeagueService leagueService;
    private TeamService teamService;

    /**
     * Model Mapper DTO
     */
    private ModelMapper modelMapper;

    /**
     * Auto wire all services and dto through constructor injection
     * @param matchService take the match service
     * @param leagueService take the league service
     * @param teamService take the team service
     * @param modelMapper take the model mapper
     */
    @Autowired
    public MatchController(MatchService matchService, LeagueService leagueService, TeamService teamService, ModelMapper modelMapper) {
        this.matchService = matchService;
        this.leagueService = leagueService;
        this.teamService = teamService;
        this.modelMapper = modelMapper;
    }

    /**
     * Creating a match by POST request method with specific url using:
     * league, team and match services
     * @param matchMainDto take the match dto
     * @return the created match
     */
    @PostMapping
    public MatchMainDto create(@RequestBody @Valid MatchMainDto matchMainDto) {
        Match match = modelMapper.map(matchMainDto, Match.class);
        League league = leagueService.read(matchMainDto.getLeagueId());
        Team homeTeam = teamService.read(matchMainDto.getHomeTeamId());
        Team awayTeam = teamService.read(matchMainDto.getAwayTeamId());
        match.setLeague(league);
        match.setHomeTeam(homeTeam);
        match.setAwayTeam(awayTeam);
        matchService.create(match);
        return matchMainDto;
    }

    /**
     * Reading specific match by GET request method with specific url and match service
     * @param id take the match id
     * @return the found match
     */
    @GetMapping(value = "/{id}")
    public MatchPresentationDto read(@PathVariable Long id) {
        Match match = matchService.read(id);
        return modelMapper.map(match, MatchPresentationDto.class);
    }

    /**
     * Reading all matches by GET request method with specific url and match service
     * @return the matches list
     */
    @GetMapping
    public List<MatchPresentationDto> readAll() {
        List<MatchPresentationDto> matchPresentationDtos = new ArrayList<>();
        List<Match> matches = matchService.readAll();
        for (Match match : matches) {
            matchPresentationDtos.add(modelMapper.map(match, MatchPresentationDto.class));
        }

        return matchPresentationDtos;
    }

    /**
     * Reading all league's matches by GET request method with specific url and match service
     * @param id take the league id
     * @return the league's matches list
     */
    @GetMapping(value = "-by-league/{id}")
    public List<MatchPresentationDto> readAllLeagueMatches(@PathVariable Long id) {
        List<MatchPresentationDto> matchPresentationDtos = new ArrayList<>();
        List<Match> matches = matchService.readAllLeagueMatches(id);
        for (Match match : matches) {
            matchPresentationDtos.add(modelMapper.map(match, MatchPresentationDto.class));
        }

        return matchPresentationDtos;
    }

    /**
     * Reading all home team matches by GET request method with specific url and match service
     * @param id take the home team id
     * @return the home team matches list
     */
    @GetMapping(value = "-as-home-team/{id}")
    public List<MatchPresentationDto> readAllHomeTeamMatches(@PathVariable Long id) {
        List<MatchPresentationDto> matchPresentationDtos = new ArrayList<>();
        List<Match> matches = matchService.readAllHomeTeamMatches(id);
        for (Match match : matches) {
            matchPresentationDtos.add(modelMapper.map(match, MatchPresentationDto.class));
        }

        return matchPresentationDtos;
    }

    /**
     * Reading all away team matches by GET request method with specific url and match service
     * @param id take the away team id
     * @return the away team matches list
     */
    @GetMapping(value = "-as-away-team/{id}")
    public List<MatchPresentationDto> readAllAwayTeamMatches(@PathVariable Long id) {
        List<MatchPresentationDto> matchPresentationDtos = new ArrayList<>();
        List<Match> matches = matchService.readAllAwayTeamMatches(id);
        for (Match match : matches) {
            matchPresentationDtos.add(modelMapper.map(match, MatchPresentationDto.class));
        }

        return matchPresentationDtos;
    }

    /**
     * Updating existing match by PUT request method with specific url and match service
     * @param matchMainDto take the new match dto data
     * @param id take the match id which we want to update
     * @return the updated match
     */
    @PutMapping(value = "/{id}")
    public MatchMainDto update(@RequestBody MatchMainDto matchMainDto, @PathVariable Long id) {
        matchMainDto.setId(id);
        Match match = modelMapper.map(matchMainDto, Match.class);
        Match existingMatch = matchService.read(id);
        BeanUtils.copyProperties(match, existingMatch);
        matchService.update(existingMatch);
        return matchMainDto;
    }

    /**
     * Deleting existing match by DELETE request method with specific url and match service
     * @param id take the match id which we want to delete
     * @return the delete result
     */
    @DeleteMapping(value = "/{id}")
    public boolean delete(@PathVariable Long id) {
        return matchService.delete(id);
    }


}
