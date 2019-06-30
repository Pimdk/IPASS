package endpoints;

import dbcontexts.TeamPostgresContext;
import repositories.TeamRepository;

public class TeamEndpoint {
    private TeamRepository teamRepository = new TeamRepository(new TeamPostgresContext());
}
