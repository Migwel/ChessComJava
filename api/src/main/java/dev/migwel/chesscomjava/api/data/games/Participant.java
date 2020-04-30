package dev.migwel.chesscomjava.api.data.games;

public record Participant(String username,
                          Long rating,
                          String result,
                          String id)
{}
