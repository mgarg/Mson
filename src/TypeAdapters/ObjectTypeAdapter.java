package TypeAdapters;

import java.lang.reflect.Field;

import Main.Mson;

public class ObjectTypeAdapter implements TypeAdapter{
    @Override
    public String toJson(Field field, Object fieldInstance) throws NoSuchFieldException, IllegalAccessException {
        Mson mson = new Mson();
        StringBuilder str = new StringBuilder();
        str.append("\""+field.getName()+"\":");
        str.append(mson.toJson(fieldInstance));
        return str.toString();
    }
}
