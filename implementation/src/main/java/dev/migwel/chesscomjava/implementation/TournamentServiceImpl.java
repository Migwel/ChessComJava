package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.data.club.Club;
import dev.migwel.chesscomjava.api.data.club.ClubMatches;
import dev.migwel.chesscomjava.api.data.club.ClubMembers;
import dev.migwel.chesscomjava.api.data.tournament.RoundGroup;
import dev.migwel.chesscomjava.api.data.tournament.Tournament;
import dev.migwel.chesscomjava.api.data.tournament.TournamentRound;
import dev.migwel.chesscomjava.api.services.ClubService;
import dev.migwel.chesscomjava.api.services.TournamentService;

public class TournamentServiceImpl implements TournamentService {

    private final ChessComFetcher fetcher;

    public TournamentServiceImpl(ChessComFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public Tournament getTournament(String urlId) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/tournament/%s", urlId), Tournament.class);
    }

    @Override
    public TournamentRound getRound(String urlId, String round) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/tournament/%s/%s", urlId, round), TournamentRound.class);
    }

    @Override
    public RoundGroup getGroup(String urlId, String round, String group) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/tournament/%s/%s/%s", urlId, round, group), RoundGroup.class);
    }
}
