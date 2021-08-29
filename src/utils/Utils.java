package utils;

public interface Utils {
    static int random(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
