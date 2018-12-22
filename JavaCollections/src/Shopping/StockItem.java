package Shopping;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int quantity;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public StockItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity - reserved;
    }

    public int reserveStock(int quantity) {
        if (quantity <= this.getQuantity()) {
            reserved += quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity) {
        if (quantity <= this.reserved) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public int finalizeStock(int quantity) {
        if (quantity <= reserved) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantity + quantity;
        if (newQuantity >= 0) {
            this.quantity = newQuantity;
        }
    }

    @Override
    public boolean equals(Object o) {
//        System.out.println("Entering StockItem.equals.");
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
//        StockItem StockItem = (StockItem) o;
//        return Double.compare(StockItem.price, price) == 0 &&
//                quantity == StockItem.quantity &&
//                name.equals(StockItem.name);
        String oName = ((StockItem) o).getName();
        return this.name.equals(oName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 22;
//        This '22' can be any number.
    }

    @Override
    public int compareTo(StockItem stockItem) {
        if (this == stockItem) {
            return 0;
        }

        if (stockItem != null) {
            return this.name.compareToIgnoreCase(stockItem.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price + ". Reserved " + this.reserved;
    }
}
