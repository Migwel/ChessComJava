package dev.migwel.chesscomjava.api.data.leaderboard;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LeaderboardPlayer(@JsonProperty("player_id") String playerId,
                                @JsonProperty("@id") String id,
                                String url,
                                String username,
                                Long score,
                                Long rank)
{}
