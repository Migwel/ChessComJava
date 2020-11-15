package dev.migwel.chesscomjava.api.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MatchSettings(@JsonProperty("time_class") String timeClass,
                            @JsonProperty("time_control") String timeControl,
                            @JsonProperty("initial_setup") String initialSetup,
                            @JsonProperty("rules") String rules,
                            @JsonProperty("min_team_players") Long minTeamPlayers,
                            @JsonProperty("max_team_players") Long maxTeamPlayers,
                            @JsonProperty("min_required_games") Long minRequiredGames,
                            @JsonProperty("min_rating") Long minRating,
                            @JsonProperty("time_increment") Long timeIncrement,
                            @JsonProperty("autostart") Boolean autostart)
{}
