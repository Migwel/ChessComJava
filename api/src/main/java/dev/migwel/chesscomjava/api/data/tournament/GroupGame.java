package dev.migwel.chesscomjava.api.data.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.migwel.chesscomjava.api.data.Color;
import dev.migwel.chesscomjava.api.data.games.Participant;

import java.util.Date;

public record GroupGame(Participant white,
                        Participant black,
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
                        String eco)
{}