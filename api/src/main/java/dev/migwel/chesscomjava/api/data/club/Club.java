package dev.migwel.chesscomjava.api.data.club;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.Date;

public record Club(@SerializedName("@id") String id,
                   String name,
                   @SerializedName("club_id") Long clubId,
                   String icon,
                   String country,
                   @SerializedName("average_daily_rating") Long averageDailyRating,
                   @SerializedName("members_count") Long membersCount,
                   Date created,
                   @SerializedName("last_activity") Date lastActivity,
                   String visibility,
                   @SerializedName("join_request") String joinRequest,
                   Collection<String> admin,
                   String description)
{}
