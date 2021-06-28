package collections.data;

public class Pesho implements Comparable<Pesho> {

    public int age;

    public String name;

    public Pesho (String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Pesho o) {
        if (this.name.equals(o.name)){
            if (this.age == o.age){
                return 0;
            } else if(this.age > o.age){
                return 1;
            } else {
                return -1;
            }
        }else {
            return this.name.compareToIgnoreCase(o.name);
        }
    }
}
