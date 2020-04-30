package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.club.Club;
import dev.migwel.chesscomjava.api.club.ClubMatches;
import dev.migwel.chesscomjava.api.club.ClubMembers;
import dev.migwel.chesscomjava.services.ClubService;

class ClubServiceImpl implements ClubService {

    private final ChessComFetcher fetcher;

    public ClubServiceImpl(ChessComFetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public Club getClub(String urlId) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/club/%s", urlId), Club.class);
    }

    @Override
    public ClubMembers getClubMembers(String urlId) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/club/%s/members", urlId), ClubMembers.class);
    }

    @Override
    public ClubMatches getClubMatches(String urlId) {
        return fetcher.fetch(String.format("https://api.chess.com/pub/club/%s/matches", urlId), ClubMatches.class);
    }
}
