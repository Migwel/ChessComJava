package dev.migwel.chesscomjava.api.data.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TournamentSettings(String type,
                                 String rules,
                                 @JsonProperty("time_class") String timeClass,
                                 @JsonProperty("time_control") String timeControl,
                                 @JsonProperty("is_rated") Boolean isRated,
                                 @JsonProperty("is_official") Boolean isOfficial,
                                 @JsonProperty("is_invite_only") Boolean isInviteOnly,
                                 @JsonProperty("initial_group_size") Long initialGroupSize,
                                 @JsonProperty("user_advance_count") Long userAdvanceCount,
                                 @JsonProperty("use_tiebreak") Boolean useTiebreak,
                                 @JsonProperty("allow_vacation") Boolean allowVacation,
                                 @JsonProperty("winner_places") Long winnerPlaces,
                                 @JsonProperty("registered_user_count") Long registeredUserCount,
                                 @JsonProperty("games_per_opponent") Long gamesPerOpponent,
                                 @JsonProperty("total_rounds") Long totalRounds,
                                 @JsonProperty("concurrent_games_per_opponent") Long concurrentGamesPerOpponent)
{}
