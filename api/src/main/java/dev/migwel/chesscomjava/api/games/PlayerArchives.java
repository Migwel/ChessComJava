package dev.migwel.chesscomjava.api.games;

import com.google.gson.annotations.SerializedName;
import dev.migwel.chesscomjava.api.Color;

import java.util.Collection;

public record PlayerArchives(Collection<String> archives)
{}
