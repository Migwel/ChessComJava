package dev.migwel.chesscomjava.api.services;

import dev.migwel.chesscomjava.api.data.tournament.RoundGroup;
import dev.migwel.chesscomjava.api.data.tournament.Tournament;
import dev.migwel.chesscomjava.api.data.tournament.TournamentRound;

public interface TournamentService {
    Tournament getTournament(String urlId);
    TournamentRound getRound(String urlId, String round);
    RoundGroup getGroup(String urlId, String round, String group);
}
