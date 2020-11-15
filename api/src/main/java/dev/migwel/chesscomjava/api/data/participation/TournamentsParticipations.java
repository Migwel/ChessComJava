package dev.migwel.chesscomjava.api.data.participation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record TournamentsParticipations(@JsonProperty("finished") Collection<TournamentParticipation> finished,
                                        @JsonProperty("in_progress") Collection<TournamentParticipation> inProgress,
                                        @JsonProperty("registered") Collection<TournamentParticipation> registered) {
}
