package snmi.matchet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import snmi.matchet.entity.Match;

import java.util.List;

/**
 * Match repository which communicate with the database. Extending the JPA repository.
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findByLeagueId(Long id);
    List<Match> findByHomeTeamId(Long id);
    List<Match> findByAwayTeamId(Long id);

}
