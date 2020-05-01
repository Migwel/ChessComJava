package dev.migwel.chesscomjava.api.data.tournament;

import com.google.gson.annotations.SerializedName;

public record TournamentSettings(String type,
                                 String rules,
                                 @SerializedName("time_class") String timeClass,
                                 @SerializedName("time_control") String timeControl,
                                 @SerializedName("is_rated") Boolean isRated,
                                 @SerializedName("is_official") Boolean isOfficial,
                                 @SerializedName("is_invite_only") Boolean isInviteOnly,
                                 @SerializedName("initial_group_size") Long initialGroupSize,
                                 @SerializedName("user_advance_count") Long userAdvanceCount,
                                 @SerializedName("use_tiebreak") Boolean useTiebreak,
                                 @SerializedName("allow_vacation") Boolean allowVacation,
                                 @SerializedName("winner_places") Long winnerPlaces,
                                 @SerializedName("registered_user_count") Long registeredUserCount,
                                 @SerializedName("games_per_opponent") Long gamesPerOpponent,
                                 @SerializedName("total_rounds") Long totalRounds,
                                 @SerializedName("concurrent_games_per_opponent") Long concurrentGamesPerOpponent)
{}
