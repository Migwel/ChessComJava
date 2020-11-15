package dev.migwel.chesscomjava.api.data.club;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Date;

public record Club(@JsonProperty("@id") String id,
                   @JsonProperty("name") String name,
                   @JsonProperty("club_id") Long clubId,
                   @JsonProperty("icon") String icon,
                   @JsonProperty("country") String country,
                   @JsonProperty("average_daily_rating") Long averageDailyRating,
                   @JsonProperty("members_count") Long membersCount,
                   @JsonProperty("created") Date created,
                   @JsonProperty("last_activity") Date lastActivity,
                   @JsonProperty("visibility") String visibility,
                   @JsonProperty("join_request") String joinRequest,
                   @JsonProperty("admin") Collection<String> admin,
                   @JsonProperty("description") String description)
{}
