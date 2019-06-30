package endpoints;

import dbcontexts.CompetitionPostgresContext;
import repositories.CompetitionRepository;

public class CompetitionEndpoint {
    private CompetitionRepository competitionRepository = new CompetitionRepository(new CompetitionPostgresContext());
}
