package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.participation.Clubs;
import dev.migwel.chesscomjava.api.participation.MatchesParticipations;
import dev.migwel.chesscomjava.api.participation.TournamentsParticipations;
import dev.migwel.chesscomjava.services.ParticipationService;
import org.junit.jupiter.api.Test;

class ParticipationServiceImplTest {

    private final ChessComFetcher chessComFetcher = new ChessComFetcher();
    private final ParticipationService participationService = new ParticipationServiceImpl(chessComFetcher);

    @Test
    void testGetClubs() {
        Clubs clubs = participationService.getClubs("erik");
        System.out.println(clubs);
    }

    @Test
    void testGetMatches() {
        MatchesParticipations matchesParticipations = participationService.getMatches("erik");
        System.out.println(matchesParticipations);
    }

    @Test
    void testGetTournaments() {
        TournamentsParticipations tournamentsParticipations = participationService.getTournaments("erik");
        System.out.println(tournamentsParticipations);
    }

}