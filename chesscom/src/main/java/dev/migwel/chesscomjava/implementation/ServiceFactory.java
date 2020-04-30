package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.services.*;

public final class ServiceFactory {

    private static final HttpClient httpClient = new HttpClient();
    private static final ChessComFetcher chessComFetcher = new ChessComFetcher(httpClient);
    private static final GameService gameService = new GameServiceImpl(chessComFetcher);
    private static final ParticipationService participationService = new ParticipationServiceImpl(chessComFetcher);
    private static final PlayerService playerService = new PlayerServiceImpl(chessComFetcher);
    private static final StreamerService streamerService = new StreamerServiceImpl(chessComFetcher);
    private static final ClubService clubService = new ClubServiceImpl(chessComFetcher);

    public static GameService getGameService() {
        return gameService;
    }

    public static ParticipationService getParticipationService() {
        return participationService;
    }

    public static PlayerService getPlayerService() {
        return playerService;
    }

    public static StreamerService getStreamerService() {
        return streamerService;
    }

    public static ClubService getClubService() {
        return clubService;
    }
}