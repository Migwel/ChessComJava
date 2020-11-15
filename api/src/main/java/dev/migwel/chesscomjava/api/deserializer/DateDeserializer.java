package dev.migwel.chesscomjava.api.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Date;

public class DateDeserializer extends StdDeserializer<Date> {

    public DateDeserializer() {
        super(Date.class);
    }

    protected DateDeserializer(Class<?> vc) {
        super(vc);
    }

    protected DateDeserializer(JavaType valueType) {
        super(valueType);
    }

    protected DateDeserializer(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        long timestamp = jsonParser.getLongValue();
        return new Date(timestamp * 1000L);
    }
}
