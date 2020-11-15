package dev.migwel.chesscomjava.api.data.games;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.migwel.chesscomjava.api.data.Color;

import java.util.Date;

public record PlayerGame(String white,
                         String black,
                         String url,
                         String fen,
                         String pgn, //TODO: Create a PGN object that would be easier to use
                         Color turn,
                         @JsonProperty("move_by") Date moveBy,
                         @JsonProperty("draw_offer") Color drawOffer,
                         @JsonProperty("last_activity") Date lastActivity,
                         @JsonProperty("start_time") Date startTime,
                         @JsonProperty("time_control") String timeControl,
                         @JsonProperty("time_class") String timeClass,
                         String rules,
                         String tournament,
                         String match)
{}
