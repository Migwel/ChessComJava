package dev.migwel.chesscomjava.api.data.player;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PlayerOnline(@JsonProperty("online") boolean online)
{}
