package dbcontexts;

import models.Competition;

import java.util.List;

public class CompetitionPostgresContext implements CompetitionContext {
    @Override
    public void createCompetition(Competition competition) {

    }

    @Override
    public Competition readCompetition(int id) {
        return null;
    }

    @Override
    public List<Competition> getAllCompetitions() {
        return null;
    }

    @Override
    public void updateCompetition(Competition competition) {

    }

    @Override
    public void deleteCompetition(Competition competition) {

    }
}
