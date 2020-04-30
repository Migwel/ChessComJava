package dev.migwel.chesscomjava.api.data.participation;

import com.google.gson.annotations.SerializedName;

public record MatchParticipation(String name,
                                 String url,
                                 @SerializedName("@id") String id,
                                 String club,
                                 Results results,
                                 String board)
{}
