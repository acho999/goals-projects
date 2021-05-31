import java.math.BigInteger;

public class LongComputationClass implements Runnable {
    private BigInteger base;
    private BigInteger pow;

    public LongComputationClass(BigInteger base, BigInteger pow) {
        this.base = base;
        this.pow = pow;
    }

    @Override
    public void run() {
        System.out.println(this.base + "^" + "" + this.pow + "=" + this.powBase(this.base, this.pow));
    }

    public BigInteger powBase(BigInteger base, BigInteger pow) {

        BigInteger result = BigInteger.ONE;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(pow) != 0; i = i.add(BigInteger.ONE)) {
            if (Thread.interrupted()) {//this will be executed when somwhere in code we call thread.interrupt() method
                System.out.println("thread interrupt exception");

                return BigInteger.ZERO;
            }
            result = result.multiply(base);
        }
        ;
        return result;
    }
}
