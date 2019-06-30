package dbcontexts;

import models.Competition;

import java.util.List;

public interface CompetitionContext {

    void createCompetition(Competition competition);

    Competition readCompetition(int id);

    List<Competition> getAllCompetitions();

    void updateCompetition(Competition competition);

    void deleteCompetition(Competition competition);

}
