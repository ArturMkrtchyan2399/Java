package myproject.model;

public class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        setName(name);
        setAuthor(author);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.isEmpty()) {
            this.author = author;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    @Override
    public String toString() {
        return "Name - " + name + '\n' +
                "Author - " + author + '\n' +
                "Price - " + price;
    }
}
