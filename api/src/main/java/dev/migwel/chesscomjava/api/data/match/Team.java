package dev.migwel.chesscomjava.api.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record Team(@JsonProperty("@id") String id,
                   @JsonProperty("url") String url,
                   @JsonProperty("name") String name,
                   @JsonProperty("score") Float score,
                   @JsonProperty("result") String result,
                   @JsonProperty("players") Collection<TeamPlayer> players,
                   @JsonProperty("fair_play_removals") Collection<String> fair_play_removals)
{}
