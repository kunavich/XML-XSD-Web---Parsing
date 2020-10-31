package by.kunavich.xmlTask.entity;

public enum  CardType {
    Greeting_Card("Greeting-Card"),
    Advertising_Card("Advertising-Card");

    private final String tagName;

    CardType(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }
}