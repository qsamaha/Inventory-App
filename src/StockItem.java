public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int quantityStock = 0;
    private int reserve = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getReserve(){
        return reserve;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public int availableQuantity(){
        return quantityStock - reserve;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public boolean reserveItem(int quantity){
        if(this.quantityInStock() < quantity || quantity < 0){
            System.out.println("Not a valid quantity");
            return false;
        }

        this.reserve += quantity;
        return true;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if (obj == this) {
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if (this == o) {
            return 0;
        }

        if (o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": price " + this.price;
    }
}
