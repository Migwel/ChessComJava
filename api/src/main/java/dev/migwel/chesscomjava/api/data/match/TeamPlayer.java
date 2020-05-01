package dev.migwel.chesscomjava.api.data.match;

import com.google.gson.annotations.SerializedName;

public record TeamPlayer(String username,
                         String board,
                         String stats,
                         Long rating,
                         Float rd,
                         @SerializedName("timeout_percent") Float timeoutPercent,
                         String status,
                         @SerializedName("played_as_white") String playedAsWhite,
                         @SerializedName("played_as_black") String playedAsBlack)
{}
