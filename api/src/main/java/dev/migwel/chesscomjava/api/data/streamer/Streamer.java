package dev.migwel.chesscomjava.api.data.streamer;

import com.google.gson.annotations.SerializedName;

public record Streamer(String username,
                       String avatar,
                       @SerializedName("twitch_url") String twitchUrl,
                       String url)
{}
