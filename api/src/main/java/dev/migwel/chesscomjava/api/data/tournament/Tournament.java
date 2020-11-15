package dev.migwel.chesscomjava.api.data.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Date;

public record Tournament(@JsonProperty("name") String name,
                         @JsonProperty("url") String url,
                         @JsonProperty("description") String description,
                         @JsonProperty("creator") String creator,
                         @JsonProperty("status") String status,
                         @JsonProperty("finish_time") Date finishTime,
                         @JsonProperty("settings") TournamentSettings settings,
                         @JsonProperty("players") Collection<TournamentPlayer> players,
                         @JsonProperty("rounds") Collection<String>rounds)
{}
