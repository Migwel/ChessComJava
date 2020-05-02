package dev.migwel.chesscomjava.api.services;

public interface ServiceFactory {
    ClubService getClubService();
    GameService getGameService();
    ParticipationService getParticipationService();
    PlayerService getPlayerService();
    StreamerService getStreamerService();
    TournamentService getTournamentService();
    MatchService getMatchService();
    CountryService getCountryService();
    PuzzleService getPuzzleService();
}
