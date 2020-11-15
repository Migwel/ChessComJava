package dev.migwel.chesscomjava.api.data.participation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record Club(@JsonProperty("@id") String id,
                   @JsonProperty("name") String name,
                   @JsonProperty("last_activity") Date lastActivity,
                   @JsonProperty("icon") String icon,
                   @JsonProperty("url") String url,
                   @JsonProperty("joined") Date joined)
{}
