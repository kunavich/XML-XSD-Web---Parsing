package by.kunavich.xmlTask.entity;

public enum CardParameter {
    VALUABLE("Valuable"),
    AUTHOR_ID("author-id"),
    AUTHOR("Author"),
    THEME("Theme"),
    YEAR("Year"),
    ADVERTISE("Advertise"),
    GREETING_DATE("greeting-date");


    private final String tagName;

    CardParameter(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }
}