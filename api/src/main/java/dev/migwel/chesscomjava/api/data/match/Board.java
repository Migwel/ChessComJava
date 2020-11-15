package dev.migwel.chesscomjava.api.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Map;

public record Board(@JsonProperty("board_scores") Map<String, Float> boardScores,
                    Collection<BoardGame> games)
{}
