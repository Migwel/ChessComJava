package dev.migwel.chesscomjava.api.data.match;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public record Match(@SerializedName("@id") String id,
                    String name,
                    String url,
                    String description,
                    @SerializedName("start_time")Date startTime,
                    MatchSettings settings,
                    String status,
                    Long boards,
                    Teams teams)
{}
