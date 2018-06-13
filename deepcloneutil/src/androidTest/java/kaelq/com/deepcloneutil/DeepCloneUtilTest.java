package kaelq.com.deepcloneutil;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class DeepCloneUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void deepClone() throws Exception {
        One o = new One();
        o.setNumber(2);

        assertTrue(DeepCloneUtil.deepClone(o) != o);
        assertTrue(((One) DeepCloneUtil.deepClone(o)).equals(o));

        OneSerializable os = new OneSerializable();
        os.setNumber(2);

        assertTrue(DeepCloneUtil.deepClone(os) != os);
        assertTrue(((OneSerializable) DeepCloneUtil.deepClone(os)).equals(os));

        OneParcelable op = new OneParcelable();
        op.setNumber(2);

        assertTrue(DeepCloneUtil.deepClone(op) != op);
        assertTrue(((OneParcelable) DeepCloneUtil.deepClone(op)).equals(op));
    }

    @Test
    public void deepClone1() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("test");
        assertTrue(DeepCloneUtil.deepClone(list, String.class) != list);
        assertTrue(DeepCloneUtil.deepClone(list, String.class).equals(list));


        List<Integer> listInt = new ArrayList<>();
        listInt.add(1);
        assertTrue(DeepCloneUtil.deepClone(listInt, Integer.class) != listInt);
//        assertTrue(DeepCloneUtil.deepClone(listInt).equals(listInt));

        List<Double> listDou = new ArrayList<>();
        listDou.add(1.0);
        assertTrue(DeepCloneUtil.deepClone(listDou, Double.class) != listDou);
        assertTrue(DeepCloneUtil.deepClone(listDou).equals(listDou));

        List<One> listOne = new ArrayList<>();
        One one = new One();
        one.setNumber(1);
        listOne.add(one);
        assertTrue(DeepCloneUtil.deepClone(listOne, One.class) != listOne);
        assertTrue(DeepCloneUtil.deepClone(listOne, One.class).equals(listOne));
    }

    @Test
    public void deepClone2() throws Exception {
        Map<String, String> mapStrStr = new HashMap<>();
        mapStrStr.put("test", "test");
        assertTrue(DeepCloneUtil.deepClone(mapStrStr) != mapStrStr);
        assertTrue(((HashMap) DeepCloneUtil.deepClone(mapStrStr)).equals(mapStrStr));

        Map<Integer, Integer> mapIntInt = new HashMap<>();
        mapIntInt.put(1, 1);
        assertTrue(DeepCloneUtil.deepClone(mapIntInt) != mapIntInt);
//        assertTrue(((HashMap) DeepCloneUtil.deepClone(mapIntInt)).equals(mapIntInt));

        Map<Double, Double> mapDouDou = new HashMap<>();
        mapDouDou.put(1.0, 1.0);
        assertTrue(DeepCloneUtil.deepClone(mapDouDou) != mapDouDou);
//        assertTrue(((HashMap) DeepCloneUtil.deepClone(mapDouDou)).equals(mapDouDou));

    }

    @Test
    public void deepCloneSerializable() {
    }

    @Test
    public void deepCloneParcelable() {
    }

    @Test
    public void deepCloneObject() throws Exception {
        One o = new One();
        o.setNumber(2);
        if (DeepCloneUtil.deepCloneObject(o) == o) {
            throw new Exception("");
        }
        assertTrue(((One) DeepCloneUtil.deepCloneObject(o)).equals(o));
    }

    @Test
    public void deepCloneArrayList() {
    }

    @Test
    public void jsonToArrayList() {
    }

    @Test
    public void deepCloneMap() {
    }
}