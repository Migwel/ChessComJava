package dev.migwel.chesscomjava.api.data.games;

import com.google.gson.annotations.SerializedName;
import dev.migwel.chesscomjava.api.data.Color;

import java.util.Date;

public record PlayerGame(String white,
                         String black,
                         String url,
                         String fen,
                         String pgn, //TODO: Create a PGN object that would be easier to use
                         Color turn,
                         @SerializedName("move_by") Date moveBy,
                         @SerializedName("draw_offer") Color drawOffer,
                         @SerializedName("last_activity") Date lastActivity,
                         @SerializedName("start_time") Date startTime,
                         @SerializedName("time_control") String timeControl,
                         @SerializedName("time_class") String timeClass,
                         String rules,
                         String tournament,
                         String match)
{}
