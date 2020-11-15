package dev.migwel.chesscomjava.api.data.club;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record ClubMatch(@JsonProperty("name") String name,
                        @JsonProperty("@id") String id,
                        @JsonProperty("opponent") String opponent,
                        @JsonProperty("result") String result,
                        @JsonProperty("start_time") Date startTime,
                        @JsonProperty("time_class") String timeClass)
{}
