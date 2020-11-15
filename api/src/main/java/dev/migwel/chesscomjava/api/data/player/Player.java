package dev.migwel.chesscomjava.api.data.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.migwel.chesscomjava.api.deserializer.DateDeserializer;

import java.util.Date;

public record Player(@JsonProperty("avatar") String avatar,
                     @JsonProperty("player_id") Long id,
                     @JsonProperty("url") String url,
                     @JsonProperty("username") String username,
                     @JsonProperty("followers") Long followers,
                     @JsonProperty("country") String country,
                     @JsonProperty("last_online") @JsonDeserialize(using = DateDeserializer.class) Date lastOnline,
                     @JsonProperty("joined") Date joined,
                     @JsonProperty("status") String status,
                     @JsonProperty("is_streamer") boolean isStreamer)

{}
