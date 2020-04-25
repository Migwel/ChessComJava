package dev.migwel.chesscomjava.api.player;

import com.google.gson.annotations.SerializedName;

public record Player(String avatar,
                     @SerializedName("player_id") Long id,
                     String url,
                     String username,
                     Long followers,
                     String country,
                     @SerializedName("last_online") Long lastOnline,
                     Long joined,
                     String status,
                     @SerializedName("is_streamer") boolean isStreamer)

{}
