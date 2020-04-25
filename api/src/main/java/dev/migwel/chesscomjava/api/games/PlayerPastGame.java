package dev.migwel.chesscomjava.api.games;

import com.google.gson.annotations.SerializedName;

public record PlayerPastGame(Participant white,
                             Participant black,
                             String url,
                             String fen,
                             String pgn,
                             @SerializedName("start_time") Long startTime,
                             @SerializedName("end_time") Long endTime,
                             @SerializedName("time_control") String timeControl,
                             String rules,
                             String eco,
                             String tournament,
                             String match)
{}
