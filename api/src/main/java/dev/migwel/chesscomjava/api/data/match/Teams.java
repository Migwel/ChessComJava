package dev.migwel.chesscomjava.api.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Teams(@JsonProperty("team1") Team team1,
                    @JsonProperty("team2") Team team2)
{}
