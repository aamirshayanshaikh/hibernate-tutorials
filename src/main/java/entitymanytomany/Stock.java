package entitymanytomany;

import java.util.HashSet;
import java.util.Set;

public class Stock {
    private Integer stockId;
    private String stockName;
    private Set<Category> categories = new HashSet<Category>(0);

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
