package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.services.GameService;
import dev.migwel.chesscomjava.services.ParticipationService;
import dev.migwel.chesscomjava.services.PlayerService;
import dev.migwel.chesscomjava.services.StreamerService;

public final class ServiceFactory {

    private static final GameService gameService = new GameServiceImpl();
    private static final ParticipationService participationService = new ParticipationServiceImpl();
    private static final PlayerService playerService = new PlayerServiceImpl();
    private static final StreamerService streamerService = new StreamerServiceImpl();

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
}