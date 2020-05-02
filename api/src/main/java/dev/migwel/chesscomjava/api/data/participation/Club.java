package dev.migwel.chesscomjava.api.data.participation;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public record Club(@SerializedName("@id") String id,
                   String name,
                   @SerializedName("last_activity") Date lastActivity,
                   String icon,
                   String url,
                   Date joined)
{}
