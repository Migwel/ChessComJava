package dev.migwel.chesscomjava.api.data.participation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record MatchesParticipations(Collection<MatchParticipation> finished,
                                    @JsonProperty("in_progress") Collection<MatchParticipation> inProgress,
                                    Collection<MatchParticipation> registered)
{}
