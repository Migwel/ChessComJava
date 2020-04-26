package dev.migwel.chesscomjava.services;

import dev.migwel.chesscomjava.api.participation.Clubs;
import dev.migwel.chesscomjava.api.participation.MatchesParticipations;
import dev.migwel.chesscomjava.api.participation.TournamentsParticipations;

public interface ParticipationService {
    Clubs getClubs(String username);
    MatchesParticipations getMatches(String username);
    TournamentsParticipations getTournaments(String username);
}
