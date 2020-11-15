package dev.migwel.chesscomjava.api.data.leaderboard;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LeaderboardPlayer(@JsonProperty("player_id") String playerId,
                                @JsonProperty("@id") String id,
                                @JsonProperty("url") String url,
                                @JsonProperty("username") String username,
                                @JsonProperty("score") Long score,
                                @JsonProperty("rank") Long rank)
{}
