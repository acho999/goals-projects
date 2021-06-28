import collections.data.Pesho;
import collections.impl.CustomArrayList;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayListMain {

    public static void main(String [] args){

        CustomArrayList<Integer> list = new CustomArrayList<>();

        CustomArrayList<Pesho> list1 = new CustomArrayList<>();

        List<Integer> a = new ArrayList<>();

        list1.add(new Pesho("ivanov",19));
        list1.add(new Pesho("cecov",19));
        list1.add(new Pesho("goshov",19));
        list1.add(new Pesho("peshov",19));

        Pesho b = new Pesho("ivanov",19);

        System.out.println(list1.contains(b));

        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.insert(1,2);
        list.insert(3,4);
        list.insert(3,4);
        list.insert(3,4);
        list.insert(3,4);

        for (Integer i : list) {
            System.out.println(i);
        }

        System.out.println(list.contains(10));

        System.out.println(list);

        System.out.println(list.remove(0));

        System.out.println(list);

        System.out.println(list.get(2));

    }

}
