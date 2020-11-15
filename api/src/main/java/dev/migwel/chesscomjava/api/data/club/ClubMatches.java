package dev.migwel.chesscomjava.api.data.club;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record ClubMatches(@JsonProperty("finished") Collection<ClubMatch> finished,
                          @JsonProperty("in_progress") Collection<ClubMatch> inProgress,
                          @JsonProperty("registered") Collection<ClubMatch> registered)
{}