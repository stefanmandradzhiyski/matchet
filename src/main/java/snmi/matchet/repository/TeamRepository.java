package snmi.matchet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import snmi.matchet.entity.Team;

import java.util.List;

/**
 * Team repository which communicate with the database. Extending the JPA repository.
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByLeagueId(Long id);

}
