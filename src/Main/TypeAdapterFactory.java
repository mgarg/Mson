package Main;

import TypeAdapters.*;

public class TypeAdapterFactory {
    public static TypeAdapter getAdapter(Object fieldinstance) {
        if(fieldinstance instanceof String) {
            return new StringTypeAdapter();
        } else if(fieldinstance instanceof Integer) {
            return new IntTypeAdapter();
        } else if(fieldinstance instanceof Object[]){
            return new ArrayTypeAdapter();
        } else {
            // this should always be the last. Everything is an instance of object
            return new ObjectTypeAdapter();
        }
    }
}
