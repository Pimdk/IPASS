package repositories;

import dbcontexts.CompetitionContext;
import models.Competition;

import java.util.ArrayList;
import java.util.List;

public class CompetitionRepository {
    private CompetitionContext context;
    private List<Competition> competitions;

    public CompetitionRepository(CompetitionContext context) {
        this.context = context;
        competitions = new ArrayList<>(this.context.getAllCompetitions());
    }

    public List<Competition> getAllCompetitions()
    {
        return competitions;
    }
}
