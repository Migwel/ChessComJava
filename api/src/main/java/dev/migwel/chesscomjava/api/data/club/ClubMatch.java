package dev.migwel.chesscomjava.api.data.club;

import com.google.gson.annotations.SerializedName;

public record ClubMatch(String name,
                        @SerializedName("@id") String id,
                        String opponent,
                        String result,
                        @SerializedName("start_time") Long startTime,
                        @SerializedName("time_class") String timeClass)
{}
