package dev.migwel.chesscomjava.api.data.player;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record TitledPlayers(@JsonProperty("players") Collection<String> players)
{}
