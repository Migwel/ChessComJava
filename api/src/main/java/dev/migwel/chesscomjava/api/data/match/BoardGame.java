package dev.migwel.chesscomjava.api.data.match;

import com.google.gson.annotations.SerializedName;
import dev.migwel.chesscomjava.api.data.games.Participant;

public record BoardGame(Participant white,
                        Participant black,
                        String url,
                        String fen,
                        String pgn,
                        @SerializedName("start_time") Long startTime,
                        @SerializedName("end_time") Long endTime,
                        @SerializedName("time_control") String timeControl,
                        @SerializedName("time_class") String timeClass,
                        String rules,
                        String eco,
                        String match,
                        Boolean rated)
{}