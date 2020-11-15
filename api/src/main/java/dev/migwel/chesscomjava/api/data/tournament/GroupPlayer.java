package dev.migwel.chesscomjava.api.data.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GroupPlayer(@JsonProperty("username") String username,
                          @JsonProperty("points") Float points,
                          @JsonProperty("tie_break") Float tieBreak,
                          @JsonProperty("is_advancing") Boolean isAdvancing)
{}
