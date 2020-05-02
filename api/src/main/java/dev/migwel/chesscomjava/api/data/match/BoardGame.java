package dev.migwel.chesscomjava.api.data.match;

import com.google.gson.annotations.SerializedName;
import dev.migwel.chesscomjava.api.data.games.Participant;

import java.util.Date;

public record BoardGame(Participant white,
                        Participant black,
                        String url,
                        String fen,
                        String pgn,
                        @SerializedName("start_time")Date startTime,
                        @SerializedName("end_time") Date endTime,
                        @SerializedName("time_control") String timeControl,
                        @SerializedName("time_class") String timeClass,
                        String rules,
                        String eco,
                        String match,
                        Boolean rated)
{}