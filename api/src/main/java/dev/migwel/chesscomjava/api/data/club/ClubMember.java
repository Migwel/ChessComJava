package dev.migwel.chesscomjava.api.data.club;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClubMember(@JsonProperty("username") String username,
                         @JsonProperty("joined") String joined)
{}
