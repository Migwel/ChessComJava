package dev.migwel.chesscomjava.api.data.match;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.Map;

public record Board(@SerializedName("board_scores") Map<String, Long> boardScores,
                    Collection<BoardGame> games)
{}
