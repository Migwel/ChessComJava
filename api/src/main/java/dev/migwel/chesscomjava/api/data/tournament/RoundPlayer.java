package dev.migwel.chesscomjava.api.data.tournament;

import com.google.gson.annotations.SerializedName;

public record RoundPlayer(String username,
                          @SerializedName("is_advancing") Boolean isAdvancing)
{}
