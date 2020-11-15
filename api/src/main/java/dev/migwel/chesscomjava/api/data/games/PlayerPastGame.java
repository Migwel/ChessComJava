package dev.migwel.chesscomjava.api.data.games;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record PlayerPastGame(Participant white,
                             Participant black,
                             String url,
                             String fen,
                             String pgn,
                             @JsonProperty("start_time") Date startTime,
                             @JsonProperty("end_time") Date endTime,
                             @JsonProperty("time_control") String timeControl,
                             String rules,
                             String eco,
                             String tournament,
                             String match)
{}
