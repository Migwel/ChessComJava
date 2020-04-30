package dev.migwel.chesscomjava.services;

import dev.migwel.chesscomjava.api.club.Club;
import dev.migwel.chesscomjava.api.club.ClubMatches;
import dev.migwel.chesscomjava.api.club.ClubMembers;

public interface ClubService {
    Club getClub(String urlId);
    ClubMembers getClubMembers(String urlId);
    ClubMatches getClubMatches(String urlId);
}
