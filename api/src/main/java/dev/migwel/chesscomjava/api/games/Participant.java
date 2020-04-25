package dev.migwel.chesscomjava.api.games;

public record Participant(String username,
                          Long rating,
                          String result,
                          String id)
{}
