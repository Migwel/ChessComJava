package dev.migwel.chesscomjava.api.data.participation;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public record MatchesParticipations(Collection<MatchParticipation> finished,
                                    @SerializedName("in_progress") Collection<MatchParticipation> inProgress,
                                    Collection<MatchParticipation> registered)
{}
