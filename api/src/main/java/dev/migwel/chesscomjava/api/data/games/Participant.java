package dev.migwel.chesscomjava.api.data.games;

import com.google.gson.annotations.SerializedName;

public record Participant(String username,
                          Long rating,
                          String result,
                          @SerializedName("@id") String id,
                          String url)
{}
