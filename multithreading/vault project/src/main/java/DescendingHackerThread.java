public class DescendingHackerThread extends HackerThread {

    public DescendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        //super.run();
        for (int i = 999; i >= 0; i--) {

            try {
                if (vault.isPasswordValid(i)) {
                    System.out.println(this.getName() + ' ' + "guessed password" + ' ' + i);
                    System.exit(0);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
