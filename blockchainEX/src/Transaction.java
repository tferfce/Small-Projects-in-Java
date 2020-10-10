public class Transaction {
    private String fromName;
    private String toName;
    private long amount;
    public Transaction(String fromName, String toName, long amount) {
        this.fromName = fromName;
        this.toName = toName;
        this.amount = amount;
    }
    public String getFromName() {
        return fromName;
    }
    public void setFromName(String fromName) {
        this.fromName = fromName;
    }
    public String getToName() {
        return toName;
    }
    public void setToName(String toName) {
        this.toName = toName;
    }
    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return
                "Send From = " + fromName +
                "\nSend To =  " + toName +
                "\nAmount = " + amount
                ;
    }
}
