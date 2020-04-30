package dev.migwel.chesscomjava.api.data.participation;

import com.google.gson.annotations.SerializedName;

public record Results(@SerializedName("played_as_white") String playedAsWhite,
                      @SerializedName("played_as_black") String playedAsBlack)
{}
