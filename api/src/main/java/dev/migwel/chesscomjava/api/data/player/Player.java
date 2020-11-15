package dev.migwel.chesscomjava.api.data.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.migwel.chesscomjava.api.deserializer.DateDeserializer;

import java.util.Date;

public record Player(String avatar,
                     @JsonProperty("player_id") Long id,
                     String url,
                     String username,
                     Long followers,
                     String country,
                     @JsonProperty("last_online") @JsonDeserialize(using = DateDeserializer.class) Date lastOnline,
                     Date joined,
                     String status,
                     @JsonProperty("is_streamer") boolean isStreamer)

{}
