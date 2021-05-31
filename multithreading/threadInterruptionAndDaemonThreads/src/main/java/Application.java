import java.math.BigInteger;

public class Application {
    public static void main(String[] args) throws Exception {

        Thread th = new Thread(new LongComputationClass(new BigInteger("20"), new BigInteger("300")));
        th.start();
        th.interrupt();//this breaks thread and it throws Interrupted exception which we handle
        //in run method.
        try {
            throw new Exception();
        } catch (Exception e) {
            //throw new Exception(); if we throw ex here "hello" is unreachable code
            System.out.println(e.getMessage());
        }
        System.out.println("hello");
    }
}
