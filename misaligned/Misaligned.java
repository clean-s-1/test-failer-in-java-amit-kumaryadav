import java.util.HashMap;
import java.util.Map;

class Misaligned {

    static void printColorMap(Map<Integer, String> colorPair) {
        colorPair.forEach((k, v) -> System.out.println(k + " " + v));
    }

    static Map<Integer, String> constructColorPair() {
        Map<Integer, String> colorPair = new HashMap<>();
        String[] majorColors = {"White", "Red", "Black", "Yellow", "Violet"};
        String[] minorColors = {"Blue", "Orange", "Green", "Brown", "Slate"};
        for (int i = 0; i < majorColors.length; i++) {
            for (int j = 0; j < minorColors.length; j++) {
                colorPair.put((i * 5 + j) + 1, " | " + majorColors[i] + " | " + minorColors[j]);
            }
        }
        return colorPair;
    }

    public static void main(String[] args) {
        Map<Integer, String> colorPair = constructColorPair();
        printColorMap(colorPair);
        assert (colorPair.size() == 25);
        assert (colorPair.get(14) == "  | Black | Brown");
        assert (colorPair.get(20) == "  | Yellow | Slate");
    }
}
