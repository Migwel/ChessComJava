package dev.migwel.chesscomjava.api.data.games;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Participant(String username,
                          Long rating,
                          String result,
                          @JsonProperty("@id") String id,
                          String url)
{}
