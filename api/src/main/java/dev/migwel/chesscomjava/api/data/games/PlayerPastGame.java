package dev.migwel.chesscomjava.api.data.games;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public record PlayerPastGame(Participant white,
                             Participant black,
                             String url,
                             String fen,
                             String pgn,
                             @SerializedName("start_time") Date startTime,
                             @SerializedName("end_time") Date endTime,
                             @SerializedName("time_control") String timeControl,
                             String rules,
                             String eco,
                             String tournament,
                             String match)
{}
