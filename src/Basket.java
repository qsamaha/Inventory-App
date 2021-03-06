import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {

    private final String name;
    private final LinkedHashMap<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new LinkedHashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {

        if ((item != null) && (quantity > 0 && item.quantityInStock() >= quantity)) {
            int inBasket = (Integer) list.getOrDefault(item, 0);

            item.reserveItem(quantity);
            item.adjustStock(-quantity);
            list.put(item, inBasket + quantity);
        }

        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if((item != null) && (quantity > 0)) {
            int inBasket = (Integer) list.getOrDefault(item, 0);
            int newQuantity = inBasket - quantity;

            if (newQuantity > 0) {
                list.put(item, newQuantity);
                return quantity;
            } else if (newQuantity == 0) {
                list.remove(item);
                return quantity;
            }
        }

        return 0;
    }

    public String checkOut(StockList stockList) {
        double total = 0;
        for (Map.Entry<StockItem, Integer> entry : this.list.entrySet()) {
            stockList.sellStock(entry.getKey().getName(), entry.getValue());
            total += entry.getKey().getPrice() * entry.getKey().getReserve();
        }

        this.list.clear();
        return "Your total: " + total;
    }


    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket: " + name + " contains " + list.size() + (list.size() == 1 ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " added\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        return s + "Total cost " + totalCost + "\n";
    }
}


