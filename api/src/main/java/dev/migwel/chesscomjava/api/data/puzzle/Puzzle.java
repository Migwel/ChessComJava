package dev.migwel.chesscomjava.api.data.puzzle;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public record Puzzle(String title,
                     String url,
                     @SerializedName("publish_time") Date publishTime,
                     String fen,
                     String pgn,
                     String image)
{}
