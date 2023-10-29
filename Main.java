interface RetailStore {
    void purchaseProduct(String productName, int quantity);
}
class ActualRetailStore implements RetailStore {
    @Override
    public void purchaseProduct(String productName, int quantity) {
        System.out.println("Processing your order for " + quantity + " " + productName + "(s).");
    }
}

class ProxyRetailStore implements RetailStore {
    private ActualRetailStore realRetailStore;
    @Override
    public void purchaseProduct(String productName, int quantity) {
        if (realRetailStore == null) {
            realRetailStore = new ActualRetailStore();
        }
        realRetailStore.purchaseProduct(productName, quantity);
    }
}

public class Main {
    public static void main(String[] args) {
        RetailStore retailStore = new ProxyRetailStore();
        retailStore.purchaseProduct("Laptop", 2);
    }
}

