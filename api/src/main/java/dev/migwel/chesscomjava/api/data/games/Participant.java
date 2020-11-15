package dev.migwel.chesscomjava.api.data.games;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Participant(@JsonProperty("username") String username,
                          @JsonProperty("rating") Long rating,
                          @JsonProperty("result") String result,
                          @JsonProperty("@id") String id,
                          @JsonProperty("url") String url)
{}
