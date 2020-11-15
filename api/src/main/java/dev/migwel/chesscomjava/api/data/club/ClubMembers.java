package dev.migwel.chesscomjava.api.data.club;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record ClubMembers(Collection<ClubMember> weekly,
                          Collection<ClubMember> monthly,
                          @JsonProperty("all_time") Collection<ClubMember> allTime)
{}
