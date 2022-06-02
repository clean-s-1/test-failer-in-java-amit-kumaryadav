class TShirts {
    static String size(int cms) {
        if (cms < 38) {
            return "S";
        } else if (cms > 38 && cms < 42) {
            return "M";
        } else {
            return "L";
        }
    }

    public static void main(String[] args) {
        assert (TShirts.size(37) == "S");

        assert (TShirts.size(38) == "M");

        assert (TShirts.size(40) == "M");
        assert (TShirts.size(43) == "L");

        assert (TShirts.size(38) == "L");
    }
}
