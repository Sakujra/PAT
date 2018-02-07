import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Script {

    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("张三", 11);
        map.put("李四", 22);
        map.put("王五", 33);
        map.put("溜溜", 44);
        map.put("哈哈", 55);
        map.put("张三", 66);
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry i = (Map.Entry) it.next();
            System.out.println(i.getKey() + "：" + i.getValue());
        }

        map = new HashMap<>();
        map.put("张三", 11);
        map.put("李四", 22);
        map.put("王五", 33);
        map.put("溜溜", 44);
        map.put("哈哈", 55);
        Iterator it1 = map.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry i = (Map.Entry) it1.next();
            System.out.println(i.getKey() + "：" + i.getValue());
        }
    }
}
