package dev.migwel.chesscomjava.api.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.migwel.chesscomjava.api.data.games.Participant;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParticipantDeserializer extends StdDeserializer<Participant> {

    private final static String URL_REGEXP = "https:\\/\\/api.chess.com\\/pub\\/player\\/(.+)";
    private final static Pattern urlPattern = Pattern.compile(URL_REGEXP);

    public ParticipantDeserializer() {
        super(Participant.class);
    }

    protected ParticipantDeserializer(Class<?> vc) {
        super(vc);
    }

    protected ParticipantDeserializer(JavaType valueType) {
        super(valueType);
    }

    protected ParticipantDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public Participant deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        String participantUrl = jsonParser.getValueAsString();
        if (participantUrl == null) {
            return jsonParser.readValueAs(Participant.class);
        }

        Matcher matcher = urlPattern.matcher(participantUrl);
        String username = participantUrl;
        if (matcher.find()) {
            username = matcher.group(1);
        }
        return new Participant(username, null, null, null, participantUrl);
    }
}
