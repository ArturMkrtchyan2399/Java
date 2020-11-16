package myproject.model;

public class Fiction extends Book {
    private String genre;
    private int numberOfSales;

    public Fiction(String name, String author, double price, String genre, int numberOfSales) {
        super(name, author, price);
        setGenre(genre);
        setNumberOfSales(numberOfSales);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre != null && !genre.isEmpty()) {
            this.genre = genre;
        }
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        if (numberOfSales >= 0) {
            this.numberOfSales = numberOfSales;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Genre - " + genre + '\n' +
                "Number Of Sales - " + numberOfSales;
    }
}
