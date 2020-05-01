package dev.migwel.chesscomjava.api.data.tournament;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public record RoundGroup(@SerializedName("fair_play_removals") Collection<String> fairPlayRemovals,
                         Collection<GroupGame> games,
                         Collection<GroupPlayer> players)
{}
