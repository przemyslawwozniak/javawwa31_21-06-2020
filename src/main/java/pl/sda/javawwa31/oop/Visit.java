package pl.sda.javawwa31.oop;

import java.time.LocalDateTime;

public class Visit {

    private Customer customer;
    private LocalDateTime time;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer, LocalDateTime time) {
        this.customer = customer;
        this.time = time;
    }

    public double calcServiceExpense() {
        return serviceExpense * (1 - customer.getType().getServiceDiscountRate());
    }

    public double calcProductExpense() {
        return productExpense * (1 - customer.getType().getProductDiscountRate());
    }

    public double calcTotalExpense() {
        return calcServiceExpense() + calcProductExpense();
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }
}
