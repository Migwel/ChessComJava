package dev.migwel.chesscomjava.api.data.leaderboard;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public record Leaderboards(Collection<LeaderboardPlayer> daily,
                           Collection<LeaderboardPlayer> daily960,
                           @SerializedName("live_rapid") Collection<LeaderboardPlayer> liveRapid,
                           @SerializedName("live_blitz") Collection<LeaderboardPlayer> liveBlitz,
                           @SerializedName("live_bullet") Collection<LeaderboardPlayer> liveBullet,
                           @SerializedName("live_bughouse") Collection<LeaderboardPlayer> liveBughouse,
                           @SerializedName("live_blitz960") Collection<LeaderboardPlayer> liveBlitz960,
                           @SerializedName("live_threecheck") Collection<LeaderboardPlayer> liveThreeCheck,
                           @SerializedName("live_crazyhouse") Collection<LeaderboardPlayer> liveCrazyHouse,
                           @SerializedName("live_kingofthehill") Collection<LeaderboardPlayer> liveKingOfTheHill,
                           @SerializedName("lessons") Collection<LeaderboardPlayer> lessons,
                           @SerializedName("tactics") Collection<LeaderboardPlayer> tactics)
{}
