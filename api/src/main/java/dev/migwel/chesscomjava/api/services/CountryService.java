package dev.migwel.chesscomjava.api.services;

import dev.migwel.chesscomjava.api.data.country.Country;
import dev.migwel.chesscomjava.api.data.country.CountryClubs;
import dev.migwel.chesscomjava.api.data.country.CountryPlayers;

public interface CountryService {
    Country getCountry(String countryCode);
    CountryPlayers getPlayers(String countryCode);
    CountryClubs getClubs(String countryCode);

}
