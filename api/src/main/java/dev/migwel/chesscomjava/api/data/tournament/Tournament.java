package dev.migwel.chesscomjava.api.data.tournament;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public record Tournament(String name,
                         String url,
                         String description,
                         String creator,
                         String status,
                         @SerializedName("finish_time") Long finishTime,
                         TournamentSettings settings,
                         Collection<TournamentPlayer> players,
                         Collection<String>rounds)
{}
