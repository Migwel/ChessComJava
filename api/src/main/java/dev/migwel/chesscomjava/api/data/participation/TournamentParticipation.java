package dev.migwel.chesscomjava.api.data.participation;

import com.google.gson.annotations.SerializedName;

public record TournamentParticipation(String url,
                                      @SerializedName("@id") String id,
                                      Long wins,
                                      Long losses,
                                      Long draws,
                                      @SerializedName("points_awarded") Long pointsAwarded,
                                      Long placement,
                                      String status,
                                      @SerializedName("total_players") Long totalPlayers)
{}
