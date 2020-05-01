package dev.migwel.chesscomjava.api.data.match;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public record Team(@SerializedName("@id") String id,
                   String url,
                   String name,
                   Float score,
                   String result,
                   Collection<TeamPlayer> players,
                   Collection<String> fair_play_removals)
{}
