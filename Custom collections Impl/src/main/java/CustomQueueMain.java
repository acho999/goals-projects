import collections.CustomQueue;

public class CustomQueueMain {

    public static void main(String[] args){

        CustomQueue queue = new CustomQueue(10);

        queue.add(31);
        queue.add(49);

        System.out.print(queue.remove());
        System.out.print(queue.remove());

        queue.add(90);
        queue.add(81);
        queue.add(72);
        queue.add(22); // At this point we got to deal with wrapAround, because rear must be pointing to last position.

        System.out.print("Deleted elements from queue: ");
        System.out.print(queue.remove()+ " ");
        System.out.print(queue.remove()+ " ");
        System.out.print(queue.remove()+ " ");
        System.out.print(queue.remove()+ " ");


    }

}
