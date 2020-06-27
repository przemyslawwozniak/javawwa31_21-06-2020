package pl.sda.javawwa31.oop;

public enum MemberType {
    NONE(0.0, 0.0),
    SILVER(0.1, 0.1),
    GOLD(0.1, 0.15),
    PLATINUM(0.1, 0.2);

    private double productDiscountRate;
    private double serviceDiscountRate;

    MemberType(double productDiscountRate, double serviceDiscountRate) {
        this.productDiscountRate = productDiscountRate;
        this.serviceDiscountRate = serviceDiscountRate;
    }

    public double getProductDiscountRate() {
        return productDiscountRate;
    }

    public double getServiceDiscountRate() {
        return serviceDiscountRate;
    }
}
