package dev.migwel.chesscomjava.api.data.participation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record Clubs(@JsonProperty("clubs") Collection<Club> clubs)
{}
