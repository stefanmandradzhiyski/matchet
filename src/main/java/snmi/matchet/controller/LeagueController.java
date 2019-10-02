package snmi.matchet.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snmi.matchet.dto.LeagueMainDto;
import snmi.matchet.entity.League;
import snmi.matchet.service.LeagueService;
import snmi.matchet.util.Constants;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * League rest controller
 * Communicate with the view and league service
 * Using Model Mapper to transfer object from entity to dto or reverse dto to entity
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
@RestController
@RequestMapping(value = Constants.VERSION + Constants.LEAGUES)
public class LeagueController {

    /**
     * League service
     */
    private LeagueService leagueService;

    /**
     * Model Mapper DTO
     */
    private ModelMapper modelMapper;

    /**
     * Auto wire the league service and model mapper
     * @param leagueService take the league service
     * @param modelMapper take the model mapper
     */
    @Autowired
    public LeagueController(LeagueService leagueService, ModelMapper modelMapper) {
        this.leagueService = leagueService;
        this.modelMapper = modelMapper;
    }

    /**
     * Creating a league by POST request method with specific url and league service
     * @param leagueMainDto take the league dto
     * @return the created league dto
     */
    @PostMapping
    public LeagueMainDto create(@RequestBody @Valid LeagueMainDto leagueMainDto) {
        League league = modelMapper.map(leagueMainDto, League.class);
        leagueService.create(league);
        return leagueMainDto;
    }

    /**
     * Reading specific league by GET request method with specific url and league service
     * @param id take the id
     * @return the found league dto
     */
    @GetMapping(value = "/{id}")
    public LeagueMainDto read(@PathVariable Long id) {
        League league = leagueService.read(id);
        return modelMapper.map(league, LeagueMainDto.class);
    }

    /**
     * Readling all available leagues by GET request with specific url and league service
     * @return return leagues dto list
     */
    @GetMapping
    public List<LeagueMainDto> readAll() {
        List<LeagueMainDto> leagueMainDtos = new ArrayList<>();
        List<League> leagues = leagueService.readAll();
        for (League league : leagues) {
            leagueMainDtos.add(modelMapper.map(league, LeagueMainDto.class));
        }
        return leagueMainDtos;
    }

    /**
     * Updating existing league by PUT request method, specific id and url, and league service
     * @param leagueMainDto take the new leagueDto data
     * @param id take the league id which we want to update
     * @return the updated league dto
     */
    @PutMapping(value = "/{id}")
    public LeagueMainDto update(@RequestBody @Valid LeagueMainDto leagueMainDto, @PathVariable Long id) {
        leagueMainDto.setId(id);
        League league = modelMapper.map(leagueMainDto, League.class);
        League existingLeague = leagueService.read(id);
        BeanUtils.copyProperties(league, existingLeague);
        leagueService.update(existingLeague);
        return leagueMainDto;
    }

    /**
     * Deleting specific league by id and DELETE request method with specific url, and league service
     * @param id take the league id which we want to delete
     * @return the delete result
     */
    @DeleteMapping(value = "/{id}")
    public boolean deleteLeague(@PathVariable Long id) {
        return leagueService.delete(id);
    }
}
