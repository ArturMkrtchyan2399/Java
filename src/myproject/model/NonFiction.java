package myproject.model;

public class NonFiction extends Book {
    private String language;


    public NonFiction(String name, String author, double price, String language) {
        super(name, author, price);
        setLanguage(language);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        if (language != null && !language.isEmpty()) {
            this.language = language;
        }
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Language - " + language;
    }
}
