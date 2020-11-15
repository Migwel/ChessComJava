package dev.migwel.chesscomjava.api.data.puzzle;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record Puzzle(String title,
                     String url,
                     @JsonProperty("publish_time") Date publishTime,
                     String fen,
                     String pgn,
                     String image)
{}
