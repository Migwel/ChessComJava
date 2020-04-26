package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.participation.Clubs;
import dev.migwel.chesscomjava.api.participation.MatchesParticipations;
import dev.migwel.chesscomjava.api.participation.TournamentsParticipations;
import dev.migwel.chesscomjava.services.ParticipationService;

class ParticipationServiceImpl implements ParticipationService {

    @Override
    public Clubs getClubs(String username) {
        return ChessComFetcher.fetch(String.format("https://api.chess.com/pub/player/%s/clubs", username), Clubs.class);
    }

    @Override
    public MatchesParticipations getMatches(String username) {
        return ChessComFetcher.fetch(String.format("https://api.chess.com/pub/player/%s/matches", username), MatchesParticipations.class);
    }

    @Override
    public TournamentsParticipations getTournaments(String username) {
        return ChessComFetcher.fetch(String.format("https://api.chess.com/pub/player/%s/tournaments", username), TournamentsParticipations.class);
    }
}
