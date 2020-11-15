package dev.migwel.chesscomjava.api.data.country;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Country(@JsonProperty("@id") String id,
                      String name,
                      String code)
{}
