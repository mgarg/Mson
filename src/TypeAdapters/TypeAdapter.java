package TypeAdapters;

import java.lang.reflect.Field;

public interface TypeAdapter {
    String toJson(Field field, Object fieldInstance) throws NoSuchFieldException, IllegalAccessException;
}
