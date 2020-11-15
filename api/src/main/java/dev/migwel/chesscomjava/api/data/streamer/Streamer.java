package dev.migwel.chesscomjava.api.data.streamer;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Streamer(String username,
                       String avatar,
                       @JsonProperty("twitch_url") String twitchUrl,
                       String url)
{}
