package dev.migwel.chesscomjava.api.data.participation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record TournamentsParticipations(Collection<TournamentParticipation> finished,
                                        @JsonProperty("in_progress") Collection<TournamentParticipation> inProgress,
                                        Collection<TournamentParticipation> registered) {
}
