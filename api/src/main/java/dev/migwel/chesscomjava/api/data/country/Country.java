package dev.migwel.chesscomjava.api.data.country;

import com.google.gson.annotations.SerializedName;

public record Country(@SerializedName("@id") String id,
                      String name,
                      String code)
{}
