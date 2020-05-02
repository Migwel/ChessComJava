package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.HttpHelper;
import dev.migwel.chesscomjava.api.data.country.Country;
import dev.migwel.chesscomjava.api.data.country.CountryClubs;
import dev.migwel.chesscomjava.api.data.country.CountryPlayers;
import dev.migwel.chesscomjava.api.services.CountryService;
import dev.migwel.chesscomjava.util.FileUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CountryServiceImplTest {

    private final HttpHelper httpHelper = mock(HttpHelper.class);
    private final ChessComFetcher chessComFetcher = new ChessComFetcher(httpHelper);
    private final CountryService countryService = new CountryServiceImpl(chessComFetcher);

    @BeforeEach
    void before() throws URISyntaxException, IOException {
        String countryJson = FileUtil.loadFile("Country.json");
        String countryPlayersJson = FileUtil.loadFile("CountryPlayers.json");
        String countryClubsJson = FileUtil.loadFile("CountryClubs.json");
        when(httpHelper.httpGet(contains("country"))).thenReturn(countryJson);
        when(httpHelper.httpGet(contains("players"))).thenReturn(countryPlayersJson);
        when(httpHelper.httpGet(contains("clubs"))).thenReturn(countryClubsJson);
    }

    @Test
    void testGetCountry() {
        Country country = countryService.getCountry("IT");
        assertEquals("IT", country.code());
        assertEquals("Italy", country.name());
        assertEquals("https://api.chess.com/pub/country/IT", country.id());
    }

    @Test
    void testGetCountryPlayers() {
        CountryPlayers players = countryService.getPlayers("IT");
        assertEquals(42132, players.players().size());
        String player = players.players().iterator().next();
        assertEquals("--hugo--", player);
    }

    @Test
    void testGetCountryClubs() {
        CountryClubs clubs = countryService.getClubs("IT");
        assertEquals(434, clubs.clubs().size());
        String club = clubs.clubs().iterator().next();
        assertEquals("https://api.chess.com/pub/club/rome", club);
    }
}