package dev.migwel.chesscomjava.implementation;

import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.services.*;

public final class ServiceFactoryImpl implements ServiceFactory {

    private static final ChessComFetcher fetcher = new ChessComFetcher(new HttpClient());
    private static final GameService gameService = new GameServiceImpl(fetcher);
    private static final ParticipationService participationService = new ParticipationServiceImpl(fetcher);
    private static final PlayerService playerService = new PlayerServiceImpl(fetcher);
    private static final StreamerService streamerService = new StreamerServiceImpl(fetcher);
    private static final ClubService clubService = new ClubServiceImpl(fetcher);
    private static final TournamentService tournamentService = new TournamentServiceImpl(fetcher);
    private static final MatchService matchService = new MatchServiceImpl(fetcher);
    private static final CountryService countryService = new CountryServiceImpl(fetcher);
    private static final PuzzleService puzzleService = new PuzzleServiceImpl(fetcher);
    private static final LeaderboardService leaderboardService = new LeaderboardServiceImpl(fetcher);

    @Override
    public GameService getGameService() {
        return gameService;
    }

    @Override
    public ParticipationService getParticipationService() {
        return participationService;
    }

    @Override
    public PlayerService getPlayerService() {
        return playerService;
    }

    @Override
    public StreamerService getStreamerService() {
        return streamerService;
    }

    @Override
    public TournamentService getTournamentService() {
        return tournamentService;
    }

    @Override
    public ClubService getClubService() {
        return clubService;
    }

    @Override
    public MatchService getMatchService() {
        return matchService;
    }

    @Override
    public CountryService getCountryService() {
        return countryService;
    }

    @Override
    public PuzzleService getPuzzleService() {
        return puzzleService;
    }

    @Override
    public LeaderboardService getLeaderboardService() {
        return leaderboardService;
    }
}