//Incomplete .

package Shopping;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 0.92, 22);
        stockList.addStock(temp);

        temp = new StockItem("Car", 2.22, 2);
        stockList.addStock(temp);

        temp = new StockItem("Chair", 0.33, 6);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 0.12, 10);
        stockList.addStock(temp);

        temp = new StockItem("Door", 0.7, 5);
        stockList.addStock(temp);

        temp = new StockItem("Juice", 0.09, 70);
        stockList.addStock(temp);

        temp = new StockItem("Phone", 1.7, 22);
        stockList.addStock(temp);

        temp = new StockItem("Towel", 0.66, 12);
        stockList.addStock(temp);

        temp = new StockItem("Vase", 0.4, 5);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket basket = new Basket("Basket");
//        System.out.println(basket);


        sellItem(basket, "Car", 1);
        System.out.println(basket);

        sellItem(basket, "Car", 1);
        System.out.println(basket);

        sellItem(basket, "Car", 1);
        sellItem(basket, "Spanner", 5);
        System.out.println(basket);

        sellItem(basket, "Bread", 50);
        sellItem(basket, "Cup", 50);
        sellItem(basket, "Phone", 2);
        System.out.println(basket);

        System.out.println(stockList);

    }

    private static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        System.out.println("There are no more " + item + "'s in stock. Sorry, visit again.");
        return 0;
    }
}
