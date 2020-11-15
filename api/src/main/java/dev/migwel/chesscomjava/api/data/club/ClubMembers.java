package dev.migwel.chesscomjava.api.data.club;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record ClubMembers(@JsonProperty("weekly") Collection<ClubMember> weekly,
                          @JsonProperty("monthly") Collection<ClubMember> monthly,
                          @JsonProperty("all_time") Collection<ClubMember> allTime)
{}
