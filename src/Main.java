public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        StockItem bread = new StockItem("Bread", 0.86, 100);
        stockList.addStock(bread);

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

        Basket QsBasket = new Basket("Q");
        QsBasket.addToBasket(temp, 2);
        QsBasket.addToBasket(bread, 7);
        QsBasket.removeFromBasket(bread,3);
        //QsBasket.addToBasket(bread, 400);
        System.out.println(QsBasket);
        System.out.println(QsBasket.checkOut(stockList));
        System.out.println(QsBasket);

    }

}
