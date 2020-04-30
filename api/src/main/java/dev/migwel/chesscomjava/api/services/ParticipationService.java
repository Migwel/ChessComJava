package dev.migwel.chesscomjava.api.services;

import dev.migwel.chesscomjava.api.data.participation.Clubs;
import dev.migwel.chesscomjava.api.data.participation.MatchesParticipations;
import dev.migwel.chesscomjava.api.data.participation.TournamentsParticipations;

public interface ParticipationService {
    Clubs getClubs(String username);
    MatchesParticipations getMatches(String username);
    TournamentsParticipations getTournaments(String username);
}
