package utils.serialization;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonSerializer extends AbstractSerializer<String>
{
    private final Gson gson = new Gson();

    @Override
    public <T> T deserialize(String data, Class<T> classType)
    {
        return gson.fromJson(data, classType);
    }

    @Override
    public <T> T deserialize(String data, Type type)
    {
        return gson.fromJson(data, type);
    }

    @Override
    public String serialize(Object object)
    {
        return gson.toJson(object);
    }
}