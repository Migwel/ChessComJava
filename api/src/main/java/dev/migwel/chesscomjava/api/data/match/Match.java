package dev.migwel.chesscomjava.api.data.match;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record Match(@JsonProperty("@id") String id,
                    String name,
                    String url,
                    String description,
                    @JsonProperty("start_time")Date startTime,
                    MatchSettings settings,
                    String status,
                    Long boards,
                    Teams teams)
{}
