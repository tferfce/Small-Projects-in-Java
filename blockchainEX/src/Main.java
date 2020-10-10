public class Main {

    public static void main(String[] args) {
        Blockchain blockchain  = new Blockchain();
        Transaction transaction = new Transaction("George","Michael",250);
        blockchain.addNewBlock(transaction);
        for (int i = 0; i<blockchain.getBlockchain().size(); i++) {
            System.out.println(blockchain.getBlockchain().get(i));
        }
        blockchain.isValid();
        blockchain.getBlockchain().get(1).setHash("asdasd");
        blockchain.isValid();
    }
}
