package org.zwx.codedsite.core.parse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jony
 */
public class JsonProcessor implements IProcessor{
    /**
     * more config
     */
    private static final Gson mGson = new GsonBuilder().create();

    public JsonProcessor() {

    }

    public static <T> T process (String s, Class<T> clazz){
        if(Objects.isNull(s) || Objects.isNull(clazz)) {
            return null;
        }
        T result = null;
        try{
            result = mGson.fromJson(s, clazz);
        } catch (JsonSyntaxException e) {}
        return result;
    }

    public static Map<?, ?> process(String s) {
        return process(s, HashMap.class);
    }
}
