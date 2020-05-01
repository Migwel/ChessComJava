package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.data.country.Country;
import dev.migwel.chesscomjava.api.data.country.CountryClubs;
import dev.migwel.chesscomjava.api.data.country.CountryPlayers;
import dev.migwel.chesscomjava.api.services.CountryService;

public class CountryServiceImpl implements CountryService {
    private final ChessComFetcher fetcher;

    public CountryServiceImpl(ChessComFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public Country getCountry(String countryCode) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/country/%s", countryCode), Country.class);
    }

    @Override
    public CountryPlayers getPlayers(String countryCode) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/country/%s/players", countryCode), CountryPlayers.class);
    }

    @Override
    public CountryClubs getClubs(String countryCode) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/country/%s/clubs", countryCode), CountryClubs.class);
    }
}
