public abstract class HackerThread extends Thread {
    protected Vault vault;

    public HackerThread(Vault vault) {
        this.vault = vault;
        this.setName(this.getClass().getSimpleName());
        this.setPriority(MAX_PRIORITY);
    }

    @Override
    public void start() {
        System.out.println("Started thread" + ' ' + this.getName());
        super.start();

    }
}
