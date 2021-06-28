import collections.impl.CustomHashMap;

import java.util.Optional;
import java.util.Set;

public class CustomHashMapMain {

    public static void main(String[] args){

        CustomHashMap<Integer, Integer> map = new CustomHashMap<Integer, Integer>();

        System.out.println(map.isEmpty());

        for(int i = 0; i<10;i++){
            map.put(i,i);
        }

        map.put(1,20);

        map.remove(0);

        Set<CustomHashMap.Entry<Integer, Integer>> entries = map.entrySet();

        Optional<CustomHashMap.Entry<Integer, Integer>> ent = entries.stream().findFirst();

        System.out.println(ent.get().getKey() + " " + ent.get().getValue());

        System.out.println(map.toString());

        System.out.println("the valuse is " + map.get(1));

        System.out.println(map.isEmpty());

        System.out.println(map.size());

    }

}
