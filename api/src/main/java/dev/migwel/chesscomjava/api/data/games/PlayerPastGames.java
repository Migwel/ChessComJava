package dev.migwel.chesscomjava.api.data.games;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record PlayerPastGames(@JsonProperty("games") Collection<PlayerPastGame> games)
{}
