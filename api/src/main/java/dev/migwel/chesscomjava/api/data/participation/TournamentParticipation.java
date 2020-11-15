package dev.migwel.chesscomjava.api.data.participation;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TournamentParticipation(@JsonProperty("url") String url,
                                      @JsonProperty("@id") String id,
                                      @JsonProperty("wins") Long wins,
                                      @JsonProperty("losses") Long losses,
                                      @JsonProperty("draws") Long draws,
                                      @JsonProperty("points_awarded") Long pointsAwarded,
                                      @JsonProperty("placement") Long placement,
                                      @JsonProperty("status") String status,
                                      @JsonProperty("total_players") Long totalPlayers)
{}
