package dev.migwel.chesscomjava.api.data.player;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TacticsResults(@JsonProperty("highest") TacticsStats highest,
                             @JsonProperty("lowest") TacticsStats lowest)
{}
