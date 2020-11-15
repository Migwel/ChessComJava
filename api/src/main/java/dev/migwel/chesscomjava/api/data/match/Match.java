package dev.migwel.chesscomjava.api.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record Match(@JsonProperty("@id") String id,
                    @JsonProperty("name") String name,
                    @JsonProperty("url") String url,
                    @JsonProperty("description") String description,
                    @JsonProperty("start_time")Date startTime,
                    @JsonProperty("settings") MatchSettings settings,
                    @JsonProperty("status") String status,
                    @JsonProperty("boards") Long boards,
                    @JsonProperty("teams") Teams teams)
{}
