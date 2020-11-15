package dev.migwel.chesscomjava.api.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.migwel.chesscomjava.api.data.games.Participant;

import java.util.Date;

public record BoardGame(@JsonProperty("white") Participant white,
                        @JsonProperty("black") Participant black,
                        @JsonProperty("url") String url,
                        @JsonProperty("fen") String fen,
                        @JsonProperty("pgn") String pgn,
                        @JsonProperty("start_time")Date startTime,
                        @JsonProperty("end_time") Date endTime,
                        @JsonProperty("time_control") String timeControl,
                        @JsonProperty("time_class") String timeClass,
                        @JsonProperty("rules") String rules,
                        @JsonProperty("eco") String eco,
                        @JsonProperty("match") String match,
                        @JsonProperty("rated") Boolean rated)
{}