package dev.migwel.chesscomjava.api.data.player;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record TacticsStats(@JsonProperty("rating") Integer rating,
                           @JsonProperty("date") Date date)
{}
