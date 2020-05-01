package dev.migwel.chesscomjava.api.data.tournament;

import com.google.gson.annotations.SerializedName;
import dev.migwel.chesscomjava.api.data.Color;
import dev.migwel.chesscomjava.api.data.games.Participant;

public record GroupGame(Participant white,
                        Participant black,
                        String url,
                        String fen,
                        String pgn, //TODO: Create a PGN object that would be easier to use
                        Color turn,
                        @SerializedName("move_by") Long moveBy,
                        @SerializedName("draw_offer") Color drawOffer,
                        @SerializedName("last_activity") Long lastActivity,
                        @SerializedName("start_time") Long startTime,
                        @SerializedName("time_control") String timeControl,
                        @SerializedName("time_class") String timeClass,
                        String rules,
                        String tournament,
                        String eco)
{}