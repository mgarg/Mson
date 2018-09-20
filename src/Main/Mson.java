package Main;

import TypeAdapters.TypeAdapter;

import java.lang.reflect.Field;

public class Mson {

    // Assuming that the pojo will contain just primitive types or objects or arrays.
    public String toJson(Object obj) throws NoSuchFieldException, IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();
        Field[] fields = obj.getClass().getDeclaredFields();
        if(fields.length == 0) {
            return "{}";
        }
        stringBuilder.append("{");
        for(int i =0; i< fields.length-1; i++) {
            Field field = fields[i];
            Object fieldInstance = obj.getClass().getDeclaredField(field.getName()).get(obj);

            TypeAdapter typeAdapter = TypeAdapterFactory.getAdapter(fieldInstance);
            stringBuilder.append(typeAdapter.toJson(field, fieldInstance));
            stringBuilder.append(",");
        }
        Field field = fields[fields.length-1];
        Object fieldInstance = obj.getClass().getDeclaredField(field.getName()).get(obj);

        TypeAdapter typeAdapter = TypeAdapterFactory.getAdapter(fieldInstance);
        stringBuilder.append(typeAdapter.toJson(field, fieldInstance));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Main.Class pojo = new Main.Class();
        //Student pojo = new Student("mahak", 25);
        //int[] pojo = new int[]{1, 2, 3, 4, 5};
        Mson mson = new Mson();
        try {
            System.out.println(mson.toJson(pojo));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

// todo
// 1. use type adapters internally
// 2. use a json writer instead of sout
// 3. Write testcases so changes can be tested properly
// 4. Make the return type of everything void and pass in string builders that you can later fill