package dev.migwel.chesscomjava.api.data.player;

import java.util.Date;

public record ChessStats(long rating,
                         Date date,
                         long rd,
                         String game)
{}
