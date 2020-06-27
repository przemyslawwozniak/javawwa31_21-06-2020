package pl.sda.javawwa31.oop;

public class Customer {

    private String name;
    private MemberType type;

    public Customer(String name) {
        this.name = name;
        this.type = MemberType.NONE;
    }

    public Customer(String name, MemberType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public MemberType getType() {
        return type;
    }

    public void setType(MemberType type) {
        this.type = type;
    }
}
