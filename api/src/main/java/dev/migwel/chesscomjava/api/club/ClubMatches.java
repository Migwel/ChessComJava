package dev.migwel.chesscomjava.api.club;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public record ClubMatches(Collection<ClubMatch> finished,
                          @SerializedName("in_progress") Collection<ClubMatch> inProgress,
                          Collection<ClubMatch> registered)
{}