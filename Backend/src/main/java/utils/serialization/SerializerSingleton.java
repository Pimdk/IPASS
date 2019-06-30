package utils.serialization;

public class SerializerSingleton
{
    private static Serializer serializer = null;

    public static Serializer getInstance()
    {
        if(serializer == null)
        {
            serializer = new GsonSerializer();
        }
        return serializer;
    }
}
