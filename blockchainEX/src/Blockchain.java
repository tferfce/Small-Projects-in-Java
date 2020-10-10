import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blockchain = new ArrayList<Block>();

    public List<Block> getBlockchain() {
        return blockchain;
    }
    private void Genesis(){
        Transaction transaction = new Transaction("Thomas","Virginia",250);
        blockchain.add(new Block(0,transaction,null));
    }
    private Block getLastBlock(){
        if (blockchain.size()==0){
            Genesis();
        }
        return blockchain.get(blockchain.size()-1);
    }

    public void addNewBlock(Transaction data){
        Block prevBlock = getLastBlock();
        Block newBlock = new Block(prevBlock.getIndex()+1, data , prevBlock.getHash());
        blockchain.add(newBlock);
    }

    public boolean isValid(){
        for (int i = 1; i <blockchain.size(); i++){
            if (!blockchain.get(i).getPreviousHash().equals(blockchain.get(i-1).getHash())){
                System.out.println("Its not Valid");
                return false;
            }
            if (!blockchain.get(i).getHash().equals(blockchain.get(i).calculateHash())){
                System.out.println("Its not valid");
                return false;
            }
        }
        System.out.println("Is valid!");
        return true;
    }

    @Override
    public String toString() {
        return "Blockchain{" +
                "blockchain=" + blockchain +
                '}';
    }
}
