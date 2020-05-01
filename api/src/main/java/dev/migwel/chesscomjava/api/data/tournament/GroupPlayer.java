package dev.migwel.chesscomjava.api.data.tournament;

import com.google.gson.annotations.SerializedName;

public record GroupPlayer(String username,
                          Float points,
                          @SerializedName("tie_break") Float tieBreak,
                          @SerializedName("is_advancing") Boolean isAdvancing)
{}
