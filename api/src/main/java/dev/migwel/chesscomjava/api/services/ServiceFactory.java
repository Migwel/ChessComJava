package dev.migwel.chesscomjava.api.services;

import java.util.Iterator;
import java.util.ServiceLoader;

public final class ServiceFactory {

    private static final GameService gameService = loadService(GameService.class);
    private static final ParticipationService participationService = loadService(ParticipationService.class);
    private static final PlayerService playerService = loadService(PlayerService.class);
    private static final StreamerService streamerService = loadService(StreamerService.class);
    private static final ClubService clubService = loadService(ClubService.class);

    private static <T> T loadService(Class<T> serviceClass) {
        ServiceLoader<T> loader = ServiceLoader.load(serviceClass);
        Iterator<T> iterator = loader.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        throw new RuntimeException("Could not find implementation for class: "+ serviceClass);
    }

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