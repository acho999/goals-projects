import collections.CustomArrayList;

public class CustomArrayListMain {

    public static void main(String [] args){

        CustomArrayList<Integer> list = new CustomArrayList<>();

        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list);

        System.out.println(list.remove(0));

        System.out.println(list);

        System.out.println(list.get(2));

    }

}
