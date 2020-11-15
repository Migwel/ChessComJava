package dev.migwel.chesscomjava.api.data.streamer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record Streamers(@JsonProperty("streamers") Collection<Streamer> streamers)
{}
