package TypeAdapters;

import Main.Mson;

import java.lang.reflect.Field;

public class ArrayTypeAdapter implements TypeAdapter{
    @Override
    public String toJson(Field field, Object fieldInstance) throws NoSuchFieldException, IllegalAccessException {
        Mson mson = new Mson();
        StringBuilder str = new StringBuilder();
        str.append("\""+field.getName()+"\":");
        Object[] array = (Object[]) fieldInstance;
        if(array.length == 0) {
            str.append("[]");
            return str.toString();
        }
        str.append("[");
        for (int i = 0; i < array.length-1; i++) {
            str.append(mson.toJson(array[i]));
            str.append(",");
        }
        str.append(mson.toJson(array[array.length-1]));
        str.append("]");
        return str.toString();
    }
}
