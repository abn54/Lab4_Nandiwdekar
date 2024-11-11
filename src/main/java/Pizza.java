/**
 * Project: Systems Integration Pizza Shop
 * Purpose Details: A model class to represent a pizza order with customer details and pizza choices
 * Course: IST 242
 * Author: Aayudh Nandiwdekar
 * Date Developed: [Date]
 * Last Date Changed: [Date]
 * Revision: 1.0
 */

public class Pizza {

    private String customerName;
    private String pizzaType;
    private int quantity;

    // Constructor to initialize the pizza order
    public Pizza(String customerName, String pizzaType, int quantity) {
        this.customerName = customerName;
        this.pizzaType = pizzaType;
        this.quantity = quantity;
    }

    // Getter methods
    public String getCustomerName() {
        return customerName;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter methods
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PizzaOrder{" +
                "customerName='" + customerName + '\'' +
                ", pizzaType='" + pizzaType + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
