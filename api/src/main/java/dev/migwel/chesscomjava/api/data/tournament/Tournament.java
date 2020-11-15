package dev.migwel.chesscomjava.api.data.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Date;

public record Tournament(String name,
                         String url,
                         String description,
                         String creator,
                         String status,
                         @JsonProperty("finish_time") Date finishTime,
                         TournamentSettings settings,
                         Collection<TournamentPlayer> players,
                         Collection<String>rounds)
{}
