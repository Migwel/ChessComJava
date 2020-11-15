package dev.migwel.chesscomjava.api.data.streamer;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Streamer(@JsonProperty("username") String username,
                       @JsonProperty("avatar") String avatar,
                       @JsonProperty("twitch_url") String twitchUrl,
                       @JsonProperty("url") String url)
{}
