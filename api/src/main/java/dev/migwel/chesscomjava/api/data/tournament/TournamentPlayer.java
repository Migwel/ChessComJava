package dev.migwel.chesscomjava.api.data.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TournamentPlayer(@JsonProperty("username") String username,
                               @JsonProperty("status") String status)
{}
