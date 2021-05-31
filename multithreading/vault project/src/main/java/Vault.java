public class Vault {
    private int password;

    public Vault(int password) {
        this.password = password;

    }

    public boolean isPasswordValid(int password) throws InterruptedException {
        Thread.sleep(5);
        return this.password == password;
    }

}
