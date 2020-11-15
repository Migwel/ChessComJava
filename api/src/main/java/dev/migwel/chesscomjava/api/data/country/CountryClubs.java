package dev.migwel.chesscomjava.api.data.country;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public record CountryClubs(@JsonProperty("clubs") Collection<String> clubs)
{}
