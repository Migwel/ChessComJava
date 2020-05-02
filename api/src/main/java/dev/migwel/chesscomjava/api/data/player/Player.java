package dev.migwel.chesscomjava.api.data.player;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public record Player(String avatar,
                     @SerializedName("player_id") Long id,
                     String url,
                     String username,
                     Long followers,
                     String country,
                     @SerializedName("last_online") Date lastOnline,
                     Date joined,
                     String status,
                     @SerializedName("is_streamer") boolean isStreamer)

{}
