import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("Car", 12.5, 2);
        stockList.addStock(temp);

        temp = new StockItem("Chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("Cup", .50, 200);
        stockList.addStock(temp);
        temp = new StockItem("Cup", 0.45,7);
        stockList.addStock(temp);

        temp = new StockItem("Door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("Juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("Phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("Towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("Vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String name : stockList.items().keySet()){
            System.out.println(name);
        }

        Basket QsBasket = new Basket("Q");
        sellItem(QsBasket, "Car", 1);
        System.out.println(QsBasket);

        sellItem(QsBasket, "Car", 1 );
        System.out.println(QsBasket);

        sellItem(QsBasket, "Car", 1);
        System.out.println(QsBasket);

        sellItem(QsBasket, "Car", 1);
        sellItem(QsBasket, "Spanner", 5);
        System.out.println(QsBasket);

        sellItem(QsBasket, "Juice", 4);
        sellItem(QsBasket, "Cup", 12);
        sellItem(QsBasket, "Bread", 1);
        System.out.println(QsBasket);

        System.out.println(stockList);

        stockList.items().get("Car").adjustStock(2000);
        stockList.items().get("Car").adjustStock(-1000);
        System.out.println(stockList);
        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()){
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity){
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }

        if(stockList.sellStock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }

        return 0;
    }
}
