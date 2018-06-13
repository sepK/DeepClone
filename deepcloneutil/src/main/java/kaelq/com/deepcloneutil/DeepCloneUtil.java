package kaelq.com.deepcloneutil;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/*TODO
 * 1. Add time compare.
 * 2. Add testcase. Done
 * 3. Gson int,long,float 2 double
 * 4. Gson List<List<T>> problem
 * Support:
 * 1. Object Serializable  Parcelable
 * 2. List<String>  List<Object>  List<Double>
 * 3. Map<String,String>
 * */
public class DeepCloneUtil {
    /*
     * Object deepClone method
     * Serializable & Parcelable & Json
     * */
    public static Object deepClone(Object o) {
        if (Serializable.class.isAssignableFrom(o.getClass())) {
            try {
                return deepCloneSerializable(o);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (Parcelable.class.isAssignableFrom(o.getClass())) {
            try {
                return deepCloneParcelable(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return deepCloneObject(o);
    }

    /*
     * ArrayList deepClone method
     * */
    public static <T> List<T> deepClone(List<T> o, Class<T> clazz) {
        return deepCloneArrayList(o, clazz);
    }

    /*
     * Map deepClone method
     * */
    public static <K, V> Map<K, V> deepClone(Map<K, V> map) {
        return deepCloneMap(map);
    }


    //Serializable
    private static Object deepCloneSerializable(Object o) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object"));
        oos.writeObject(o);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object"));
        Object result = ois.readObject();
        ois.close();
        return result;
    }


    //Parcelable
    private static Object deepCloneParcelable(Object o) throws Exception {
        Parcel parcel = null;
        try {
            parcel = Parcel.obtain();
            parcel.writeParcelable((Parcelable) o, 0);
            parcel.setDataPosition(0);
            return parcel.readParcelable(o.getClass().getClassLoader());
        } finally {
            parcel.recycle();
        }
    }

    //Json object
    private static Object deepCloneObject(Object o) {
        Gson gson = new Gson();
        String object = gson.toJson(o);
        return gson.fromJson(object, o.getClass());
    }

    //ArrayList
    public static <T> List<T> deepCloneArrayList(List<T> list, Class<T> clazz) {
        Gson gson = new Gson();
        String listStr = gson.toJson(list);
        Type type = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        return gson.fromJson(listStr, type);
    }

    //Map
    public static <K, V> Map<K, V> deepCloneMap(Map<K, V> map) {
        String json = new Gson().toJson(map);
        return new Gson().fromJson(json, new TypeToken<Map<K, V>>() {
        }.getType());
    }


}
