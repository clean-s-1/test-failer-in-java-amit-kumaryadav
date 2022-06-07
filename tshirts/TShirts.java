import java.util.InputMismatchException;

class TShirts {
    static String size(int cms) {
        if (cms <= 0) {
            throw new InputMismatchException("T shirt size should be positive and greater than zero!!");
        }
        if (cms <= 38) {
            return "S";
        } else if (cms <= 42) {
            return "M";
        } else if (cms <= 46) {
            return "L";
        } else {
            throw new InputMismatchException("Size is not supported");
        }
    }

    public static void main(String[] args) {
        assert (TShirts.size(37).equals("S"));

        assert (TShirts.size(38).equals("S"));

        assert (TShirts.size(42).equals("M"));

        assert (TShirts.size(40).equals("M"));

        assert (TShirts.size(43).equals("L"));

        assert (TShirts.size(46).equals("L"));
    }
}
