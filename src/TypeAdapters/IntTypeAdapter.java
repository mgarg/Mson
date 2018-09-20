package TypeAdapters;

import java.lang.reflect.Field;

public class IntTypeAdapter implements TypeAdapter{

    @Override
    public String toJson(Field field, Object fieldInstance) {
        return "\"" + field.getName() + "\":" + fieldInstance;
    }
}
