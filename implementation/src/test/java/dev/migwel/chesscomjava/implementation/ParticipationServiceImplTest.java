package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.data.participation.*;
import dev.migwel.chesscomjava.api.services.ParticipationService;
import dev.migwel.chesscomjava.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParticipationServiceImplTest {
    private final HttpClient httpClient = mock(HttpClient.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpClient);
    private final ParticipationService participationService = new ParticipationServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String clubs = FileUtil.loadFile("Clubs.json");
        String matches = FileUtil.loadFile("Matches.json");
        String tournaments = FileUtil.loadFile("Tournaments.json");
        when(httpClient.httpGet(contains("clubs"))).thenReturn(clubs);
        when(httpClient.httpGet(contains("matches"))).thenReturn(matches);
        when(httpClient.httpGet(contains("tournaments"))).thenReturn(tournaments);
    }

    @Test
    void testGetClubs() {
        Clubs clubs = participationService.getClubs("erik");
        assertEquals(27, clubs.clubs().size());
        Club club = clubs.clubs().iterator().next();
        assertEquals("https://www.chess.com/club/open-discussion", club.url());
    }

    @Test
    void testGetFinishedMatches() {
        MatchesParticipations matchesParticipations = participationService.getMatches("erik");
        assertEquals(165, matchesParticipations.finished().size());
        MatchParticipation matchParticipation = matchesParticipations.finished().iterator().next();
        assertEquals("https://www.chess.com/club/matches/642370", 	matchParticipation.url());
        assertEquals("resigned", matchParticipation.results().playedAsBlack());
    }

    @Test
    void testGetMatchesInProgress() {
        MatchesParticipations matchesParticipations = participationService.getMatches("erik");
        assertEquals(2, matchesParticipations.inProgress().size());
        MatchParticipation matchParticipation = matchesParticipations.inProgress().iterator().next();
        assertEquals("https://www.chess.com/club/matches/1103618", 	matchParticipation.url());
        assertEquals("win", matchParticipation.results().playedAsWhite());
    }

    @Test
    void testGetFinishedTournaments() {
        TournamentsParticipations tournamentsParticipations = participationService.getTournaments("erik");
        assertEquals(132, tournamentsParticipations.finished().size());
        TournamentParticipation tournamentParticipation = tournamentsParticipations.finished().iterator().next();
        assertEquals("https://www.chess.com/tournament/100-years-of-chemotherapy---remembrance-tournament", tournamentParticipation.url());
        assertEquals(100, tournamentParticipation.totalPlayers());
    }

    @Test
    void testGetTournamentsInProgress() {
        TournamentsParticipations tournamentsParticipations = participationService.getTournaments("erik");
        assertEquals(7, tournamentsParticipations.inProgress().size());
        TournamentParticipation tournamentParticipation = tournamentsParticipations.inProgress().iterator().next();
        assertEquals("https://www.chess.com/tournament/34th-chess-com-thematic-tournament-alekhine-1401-1600", tournamentParticipation.url());
        assertEquals(1, tournamentParticipation.draws());
    }

    @Test
    void testGetRegisteredTournaments() {
        TournamentsParticipations tournamentsParticipations = participationService.getTournaments("erik");
        assertEquals(6, tournamentsParticipations.registered().size());
        TournamentParticipation tournamentParticipation = tournamentsParticipations.registered().iterator().next();
        assertEquals("https://www.chess.com/tournament/75-let-velikoi-pobedy", tournamentParticipation.url());
    }

}