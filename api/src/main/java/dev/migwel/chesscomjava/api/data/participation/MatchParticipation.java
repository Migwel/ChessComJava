package dev.migwel.chesscomjava.api.data.participation;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MatchParticipation(String name,
                                 String url,
                                 @JsonProperty("@id") String id,
                                 String club,
                                 Results results,
                                 String board)
{}
