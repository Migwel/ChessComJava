package dev.migwel.chesscomjava.api.streamer;

import com.google.gson.annotations.SerializedName;

public record Streamer(String username,
                       String avatar,
                       @SerializedName("twitch_url") String twitchUrl,
                       String url)
{}
