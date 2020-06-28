package pl.sda.javawwa31.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MyCitiesSupplier implements Supplier<List<String>> {
    @Override
    public List<String> get() {
        return Arrays.asList("Warsaw,Berlin,Frankfurt,Stuttgart,Danzig".split(","));
    }
}
