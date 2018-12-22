package Shopping;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new TreeMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
//            Check if already have quantities of this item .
            StockItem inStock = list.get(item.getName());
//            If there are already on this item, adjust the quantity.
            if (inStock != null) {
                item.adjustStock(inStock.getQuantity());
            }

            list.put(item.getName(), item);
            return item.getQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if ((inStock != null) && (inStock.getQuantity() >= quantity) && (quantity > 0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String name) {
        return list.get(name);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock list\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getQuantity();
            s += stockItem + ". There are " + stockItem.getQuantity() + " in stock" +
                    ". Value of Items " + itemValue + "\n";
            totalCost += itemValue;
//            System.out.println(totalCost);
        }
        return s + "Total Stock Value " + totalCost;
    }
}
