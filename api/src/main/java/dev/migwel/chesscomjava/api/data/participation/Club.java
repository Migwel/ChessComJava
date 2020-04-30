package dev.migwel.chesscomjava.api.data.participation;

import com.google.gson.annotations.SerializedName;

public record Club(@SerializedName("@id") String id,
                   String name,
                   @SerializedName("last_activity") Long lastActivity,
                   String icon,
                   String url,
                   Long joined)
{}
