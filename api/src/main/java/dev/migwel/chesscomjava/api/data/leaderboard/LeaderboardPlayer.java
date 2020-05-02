package dev.migwel.chesscomjava.api.data.leaderboard;

import com.google.gson.annotations.SerializedName;

public record LeaderboardPlayer(@SerializedName("player_id") String playerId,
                                @SerializedName("@id") String id,
                                String url,
                                String username,
                                Long score,
                                Long rank)
{}
