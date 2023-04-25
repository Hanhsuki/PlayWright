package pages;

public enum DataEntries {
    DATA1("text1"),
    DATA2("");

    private String data;

    DataEntries(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
