package dev.migwel.chesscomjava.api.data.tournament;

import java.util.Collection;

public record TournamentRound(Collection<String> groups,
                              Collection<RoundPlayer> players)
{}
