package dev.migwel.chesscomjava.api.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.migwel.chesscomjava.api.data.games.Participant;

import java.util.Date;

public record BoardGame(Participant white,
                        Participant black,
                        String url,
                        String fen,
                        String pgn,
                        @JsonProperty("start_time")Date startTime,
                        @JsonProperty("end_time") Date endTime,
                        @JsonProperty("time_control") String timeControl,
                        @JsonProperty("time_class") String timeClass,
                        String rules,
                        String eco,
                        String match,
                        Boolean rated)
{}