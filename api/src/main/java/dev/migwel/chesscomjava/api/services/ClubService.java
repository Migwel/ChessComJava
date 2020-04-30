package dev.migwel.chesscomjava.api.services;

import dev.migwel.chesscomjava.api.data.club.Club;
import dev.migwel.chesscomjava.api.data.club.ClubMatches;
import dev.migwel.chesscomjava.api.data.club.ClubMembers;

public interface ClubService {
    Club getClub(String urlId);
    ClubMembers getClubMembers(String urlId);
    ClubMatches getClubMatches(String urlId);
}
