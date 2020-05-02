package dev.migwel.chesscomjava.api.data.club;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public record ClubMatch(String name,
                        @SerializedName("@id") String id,
                        String opponent,
                        String result,
                        @SerializedName("start_time") Date startTime,
                        @SerializedName("time_class") String timeClass)
{}
