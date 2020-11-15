package dev.migwel.chesscomjava.api.data.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record RoundGroup(@JsonProperty("fair_play_removals") Collection<String> fairPlayRemovals,
                         @JsonProperty("games") Collection<GroupGame> games,
                         @JsonProperty("players") Collection<GroupPlayer> players)
{}
