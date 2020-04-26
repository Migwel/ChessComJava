package dev.migwel.chesscomjava.api.participation;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public record TournamentsParticipations(Collection<TournamentParticipation> finished,
                                        @SerializedName("in_progress") Collection<TournamentParticipation> inProgress,
                                        Collection<TournamentParticipation> registered) {
}
