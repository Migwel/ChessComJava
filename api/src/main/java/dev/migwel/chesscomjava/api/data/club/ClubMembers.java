package dev.migwel.chesscomjava.api.data.club;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public record ClubMembers(Collection<ClubMember> weekly,
                          Collection<ClubMember> monthly,
                          @SerializedName("all_time") Collection<ClubMember> allTime)
{}
