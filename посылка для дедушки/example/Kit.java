package gb.intermediate.example;

import java.util.Map;

public interface Kit<T> extends Iterable<T>{
    int getKitSize();
    void addToKit(T plant);
    Integer getPlantAmount(T plant);

    Map<T, Integer> getKit();
}