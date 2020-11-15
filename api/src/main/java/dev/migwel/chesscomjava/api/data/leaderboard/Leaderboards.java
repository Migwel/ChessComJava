package dev.migwel.chesscomjava.api.data.leaderboard;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record Leaderboards(@JsonProperty("daily") Collection<LeaderboardPlayer> daily,
                           @JsonProperty("daily960") Collection<LeaderboardPlayer> daily960,
                           @JsonProperty("live_rapid") Collection<LeaderboardPlayer> liveRapid,
                           @JsonProperty("live_blitz") Collection<LeaderboardPlayer> liveBlitz,
                           @JsonProperty("live_bullet") Collection<LeaderboardPlayer> liveBullet,
                           @JsonProperty("live_bughouse") Collection<LeaderboardPlayer> liveBughouse,
                           @JsonProperty("live_blitz960") Collection<LeaderboardPlayer> liveBlitz960,
                           @JsonProperty("live_threecheck") Collection<LeaderboardPlayer> liveThreeCheck,
                           @JsonProperty("live_crazyhouse") Collection<LeaderboardPlayer> liveCrazyHouse,
                           @JsonProperty("live_kingofthehill") Collection<LeaderboardPlayer> liveKingOfTheHill,
                           @JsonProperty("lessons") Collection<LeaderboardPlayer> lessons,
                           @JsonProperty("tactics") Collection<LeaderboardPlayer> tactics)
{}
