package dev.migwel.chesscomjava.api.data.participation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record Club(@JsonProperty("@id") String id,
                   String name,
                   @JsonProperty("last_activity") Date lastActivity,
                   String icon,
                   String url,
                   Date joined)
{}
