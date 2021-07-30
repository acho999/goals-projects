import collections.impl.CustomStack;

public class CustomStackMain {

    public static void main(String[] args){

        CustomStack<Integer> stack = new CustomStack<>(10);
        stack.push(11);
        stack.push(21);
        stack.push(31);
        stack.push(41);
        stack.push(51);

        for (Integer integer : stack) {
            if (integer == null) {
                break;
            }
            System.out.println(integer + " i");
        }

        System.out.print("Popped items: ");
        System.out.print(stack.pop()+" " + "\n");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");



    }

}
