package dev.migwel.chesscomjava.implementation;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dev.migwel.chesscomjava.ChessComFetcher;
import dev.migwel.chesscomjava.api.player.Player;
import dev.migwel.chesscomjava.api.player.PlayerStats;
import dev.migwel.chesscomjava.api.player.TitledPlayers;
import dev.migwel.chesscomjava.services.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerServiceImpl implements PlayerService {

    private static final Logger log = LoggerFactory.getLogger(PlayerServiceImpl.class);
    private static final Gson gson = new Gson();

    @Override
    public Player getProfile(String username) {
        return fetch(String.format("https://api.chess.com/pub/player/%s", username), Player.class);
    }

    private <T> T fetch(String url, Class<T> responseClass) {
        String response = ChessComFetcher.httpGet(url);
        T responseObject;
        try {
            responseObject = gson.fromJson(response, responseClass);
        } catch (JsonSyntaxException e) {
            log.warn("Could not deserialize response to "+ responseClass, e);
            return null;
        }
        return responseObject;
    }

    @Override
    public TitledPlayers getTitledPlayers(String title) {
        return fetch(String.format("https://api.chess.com/pub/titled/%s", title), TitledPlayers.class);
    }

    @Override
    public PlayerStats getPlayerStats(String username) {
        return fetch(String.format("https://api.chess.com/pub/player/%s/stats", username), PlayerStats.class);
    }
}
