package dev.migwel.chesscomjava.api.data.games;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record PlayerGames(@JsonProperty("games") Collection<PlayerGame> games)
{}
