package dev.migwel.chesscomjava.api.data.participation;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TournamentParticipation(String url,
                                      @JsonProperty("@id") String id,
                                      Long wins,
                                      Long losses,
                                      Long draws,
                                      @JsonProperty("points_awarded") Long pointsAwarded,
                                      Long placement,
                                      String status,
                                      @JsonProperty("total_players") Long totalPlayers)
{}
