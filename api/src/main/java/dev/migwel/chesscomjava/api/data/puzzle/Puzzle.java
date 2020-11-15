package dev.migwel.chesscomjava.api.data.puzzle;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record Puzzle(@JsonProperty("title") String title,
                     @JsonProperty("url") String url,
                     @JsonProperty("publish_time") Date publishTime,
                     @JsonProperty("fen") String fen,
                     @JsonProperty("pgn") String pgn,
                     @JsonProperty("image") String image)
{}
