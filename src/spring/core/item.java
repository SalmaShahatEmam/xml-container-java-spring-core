package spring.core;

public class item {

    private int Id;
    private String name;
    private int price;
    private int total;

    public item(int id, String name, int price, int total) {
        this.Id = id;
        this.name = name;
        this.price = price;
        this.total = total;
    }
    
    public item( String name, int price, int total) {
        this.name = name;
        this.price = price;
        this.total = total;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
