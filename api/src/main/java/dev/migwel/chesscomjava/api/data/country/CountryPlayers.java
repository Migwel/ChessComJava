package dev.migwel.chesscomjava.api.data.country;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record CountryPlayers(@JsonProperty("players") Collection<String> players)
{}
