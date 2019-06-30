package utils.serialization;

import java.lang.reflect.Type;

public interface Serializer<R>
{
    <T> T deserialize(String data, Class<T> classType);

    <T> T deserialize(String data, Type type);

    R serialize(Object object);
}
