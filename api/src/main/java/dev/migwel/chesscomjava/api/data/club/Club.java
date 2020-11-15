package dev.migwel.chesscomjava.api.data.club;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Date;

public record Club(@JsonProperty("@id") String id,
                   String name,
                   @JsonProperty("club_id") Long clubId,
                   String icon,
                   String country,
                   @JsonProperty("average_daily_rating") Long averageDailyRating,
                   @JsonProperty("members_count") Long membersCount,
                   Date created,
                   @JsonProperty("last_activity") Date lastActivity,
                   String visibility,
                   @JsonProperty("join_request") String joinRequest,
                   Collection<String> admin,
                   String description)
{}
