package dev.migwel.chesscomjava.api.data.puzzle;

import com.google.gson.annotations.SerializedName;

public record Puzzle(String title,
                     String url,
                     @SerializedName("publish_time") Long publishTime,
                     String fen,
                     String pgn,
                     String image)
{}
