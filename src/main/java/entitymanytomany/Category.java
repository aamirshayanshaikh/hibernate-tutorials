package entitymanytomany;

import java.util.HashSet;
import java.util.Set;

public class Category {
    private Integer categoryId;
    private String name;
    private Set<Stock> stocks = new HashSet<Stock>(0);

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }
}
