package dev.migwel.chesscomjava.api.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record Team(@JsonProperty("@id") String id,
                   String url,
                   String name,
                   Float score,
                   String result,
                   Collection<TeamPlayer> players,
                   Collection<String> fair_play_removals)
{}
