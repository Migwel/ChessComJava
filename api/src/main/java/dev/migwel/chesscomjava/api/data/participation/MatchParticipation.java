package dev.migwel.chesscomjava.api.data.participation;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MatchParticipation(@JsonProperty("name") String name,
                                 @JsonProperty("url") String url,
                                 @JsonProperty("@id") String id,
                                 @JsonProperty("club") String club,
                                 @JsonProperty("results") Results results,
                                 @JsonProperty("board") String board)
{}
