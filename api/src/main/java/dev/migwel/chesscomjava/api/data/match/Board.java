package dev.migwel.chesscomjava.api.data.match;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public record Board(@SerializedName("board_scores") BoardScores boardScores,
                    Collection<BoardGame> games)
{}
