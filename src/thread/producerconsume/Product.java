package thread.producerconsume;

/**
 * 产品
 * @author yangjie
 */
public class Product {
    private String name;

    public Product(){};

    public Product(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
