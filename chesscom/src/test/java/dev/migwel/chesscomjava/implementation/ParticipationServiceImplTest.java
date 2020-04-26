package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.participation.*;
import dev.migwel.chesscomjava.services.ParticipationService;
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
        assertEquals(clubs.clubs().size(), 27);
        Club club = clubs.clubs().iterator().next();
        assertEquals(club.url(), "https://www.chess.com/club/open-discussion");
    }

    @Test
    void testGetFinishedMatches() {
        MatchesParticipations matchesParticipations = participationService.getMatches("erik");
        assertEquals(matchesParticipations.finished().size(), 165);
        MatchParticipation matchParticipation = matchesParticipations.finished().iterator().next();
        assertEquals(matchParticipation.url(), 	"https://www.chess.com/club/matches/642370");
        assertEquals(matchParticipation.results().playedAsBlack(), "resigned");
    }

    @Test
    void testGetMatchesInProgress() {
        MatchesParticipations matchesParticipations = participationService.getMatches("erik");
        assertEquals(matchesParticipations.inProgress().size(), 2);
        MatchParticipation matchParticipation = matchesParticipations.inProgress().iterator().next();
        assertEquals(matchParticipation.url(), 	"https://www.chess.com/club/matches/1103618");
        assertEquals(matchParticipation.results().playedAsWhite(), "win");
    }

    @Test
    void testGetFinishedTournaments() {
        TournamentsParticipations tournamentsParticipations = participationService.getTournaments("erik");
        assertEquals(tournamentsParticipations.finished().size(), 132);
        TournamentParticipation tournamentParticipation = tournamentsParticipations.finished().iterator().next();
        assertEquals(tournamentParticipation.url(), "https://www.chess.com/tournament/100-years-of-chemotherapy---remembrance-tournament");
        assertEquals(tournamentParticipation.totalPlayers(), 100);
    }

    @Test
    void testGetTournamentsInProgress() {
        TournamentsParticipations tournamentsParticipations = participationService.getTournaments("erik");
        assertEquals(tournamentsParticipations.inProgress().size(), 7);
        TournamentParticipation tournamentParticipation = tournamentsParticipations.inProgress().iterator().next();
        assertEquals(tournamentParticipation.url(), "https://www.chess.com/tournament/34th-chess-com-thematic-tournament-alekhine-1401-1600");
        assertEquals(tournamentParticipation.draws(), 1);
    }

    @Test
    void testGetRegisteredTournaments() {
        TournamentsParticipations tournamentsParticipations = participationService.getTournaments("erik");
        assertEquals(tournamentsParticipations.registered().size(), 6);
        TournamentParticipation tournamentParticipation = tournamentsParticipations.registered().iterator().next();
        assertEquals(tournamentParticipation.url(), "https://www.chess.com/tournament/75-let-velikoi-pobedy");
    }

}