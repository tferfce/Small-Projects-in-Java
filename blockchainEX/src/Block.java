import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
    private int index;
    private Date timestamp;
    private Transaction data;
    private String previousHash;
    private String hash;

    public Block(int index, Transaction data, String previousHash) {
        this.index = index;
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date();
        this.hash = calculateHash();
    }

    public String calculateHash(){
        String text = index + previousHash + String.valueOf(timestamp) + String.valueOf(data);
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        final byte bytes[] = digest.digest(text.getBytes());
        final StringBuilder hexString = new StringBuilder();
        for (final byte b : bytes){
            String hex = Integer.toHexString(0xff &b);
            if (hex.length() == 1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Transaction getData() {
        return data;
    }

    public void setData(Transaction data) {
        this.data = data;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Block = " + index +
                "\nTimestamp = " + timestamp +
                "\n" + data.toString() +
                "\nPrevious HashCode = " + previousHash +
                "\nHashCode = " + hash+"\n";
    }
}
