package dev.migwel.chesscomjava.api.data.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record TournamentRound(@JsonProperty("groups") Collection<String> groups,
                              @JsonProperty("players") Collection<RoundPlayer> players)
{}
