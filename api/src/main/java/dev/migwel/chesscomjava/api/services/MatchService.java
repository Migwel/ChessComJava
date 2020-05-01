package dev.migwel.chesscomjava.api.services;

import dev.migwel.chesscomjava.api.data.match.Board;
import dev.migwel.chesscomjava.api.data.match.Match;

public interface MatchService {
    Match getMatch(String id);
    Match getLiveMatch(String id);
    Board getBoard(String matchId, String boardId);
    Board getLiveBoard(String matchId, String boardId);
}
