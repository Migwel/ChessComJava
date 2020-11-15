package dev.migwel.chesscomjava.api.data.games;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record PlayerPastGame(@JsonProperty("white") Participant white,
                             @JsonProperty("black") Participant black,
                             @JsonProperty("url") String url,
                             @JsonProperty("fen") String fen,
                             @JsonProperty("pgn") String pgn,
                             @JsonProperty("start_time") Date startTime,
                             @JsonProperty("end_time") Date endTime,
                             @JsonProperty("time_control") String timeControl,
                             @JsonProperty("rules") String rules,
                             @JsonProperty("eco") String eco,
                             @JsonProperty("tournament") String tournament,
                             @JsonProperty("match") String match)
{}
