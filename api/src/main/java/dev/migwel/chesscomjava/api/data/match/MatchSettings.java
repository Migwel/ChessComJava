package dev.migwel.chesscomjava.api.data.match;

import com.google.gson.annotations.SerializedName;

public record MatchSettings(@SerializedName("time_class") String timeClass,
                            @SerializedName("time_control") String timeControl,
                            @SerializedName("initial_setup") String initialSetup,
                            String rules,
                            @SerializedName("min_team_players") Long minTeamPlayers,
                            @SerializedName("max_team_players") Long maxTeamPlayers,
                            @SerializedName("min_required_games") Long minRequiredGames,
                            @SerializedName("min_rating") Long minRating,
                            @SerializedName("time_increment") Long timeIncrement,
                            Boolean autostart)
{}
