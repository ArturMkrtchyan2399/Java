package myproject.model;

public class Dictionary extends NonFiction {
    private String translateToLanguage;

    public Dictionary(String name, String author, double price, String language, String translateToLanguage) {
        super(name, author, price, language);
        setTranslateToLanguage(translateToLanguage);
    }

    public String getTranslateToLanguage() {
        return translateToLanguage;
    }

    public void setTranslateToLanguage(String translateToLanguage) {
        if (translateToLanguage != null && !translateToLanguage.isEmpty()) {
            this.translateToLanguage = translateToLanguage;
        }
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Translate To Language - " + translateToLanguage;
    }
}
