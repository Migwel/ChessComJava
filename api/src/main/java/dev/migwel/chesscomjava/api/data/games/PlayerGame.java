package dev.migwel.chesscomjava.api.data.games;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.migwel.chesscomjava.api.data.Color;

import java.util.Date;

public record PlayerGame(@JsonProperty("white") String white,
                         @JsonProperty("black") String black,
                         @JsonProperty("url") String url,
                         @JsonProperty("fen") String fen,
                         @JsonProperty("pgn") String pgn, //TODO: Create a PGN object that would be easier to use
                         @JsonProperty("turn") Color turn,
                         @JsonProperty("move_by") Date moveBy,
                         @JsonProperty("draw_offer") Color drawOffer,
                         @JsonProperty("last_activity") Date lastActivity,
                         @JsonProperty("start_time") Date startTime,
                         @JsonProperty("time_control") String timeControl,
                         @JsonProperty("time_class") String timeClass,
                         @JsonProperty("rules") String rules,
                         @JsonProperty("tournament") String tournament,
                         @JsonProperty("match") String match)
{}
