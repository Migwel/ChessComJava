package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.HttpHelper;
import dev.migwel.chesscomjava.api.data.club.*;
import dev.migwel.chesscomjava.api.services.ClubService;
import dev.migwel.chesscomjava.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClubServiceImplTest {
    private final HttpHelper httpHelper = mock(HttpHelper.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpHelper);
    private final ClubService clubService = new ClubServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String club = FileUtil.loadFile("Club.json");
        String clubMembers = FileUtil.loadFile("ClubMembers.json");
        String clubMatches = FileUtil.loadFile("ClubMatches.json");
        when(httpHelper.httpGet(contains("club"))).thenReturn(club);
        when(httpHelper.httpGet(contains("members"))).thenReturn(clubMembers);
        when(httpHelper.httpGet(contains("matches"))).thenReturn(clubMatches);
    }

    @Test
    void testGetClub() {
        Club club = clubService.getClub("chess-com-developer-community");
        assertEquals(4, club.admin().size());
        assertEquals("Chess.com Developer Community", club.name());
    }

    @Test
    void testGetClubMembers() {
        ClubMembers clubMembers = clubService.getClubMembers("chess-com-developer-community");
        assertEquals(169, clubMembers.weekly().size());
        ClubMember clubMember = clubMembers.weekly().iterator().next();
        assertEquals("0xword", clubMember.username());
    }

    @Test
    void testGetClubMatches() {
        ClubMatches clubMatches = clubService.getClubMatches("team-usa-southwest");
        assertEquals(181, clubMatches.finished().size());
        ClubMatch clubMatch = clubMatches.finished().iterator().next();
        assertEquals("https://api.chess.com/pub/club/usasc", clubMatch.opponent());
    }
}