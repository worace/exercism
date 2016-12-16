public class Hamming {
    public static Integer compute(String left, String right) {
        if (left.length() != right.length())
            throw new IllegalArgumentException("Strands must be same length");
        Integer dist = 0;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i))
                dist++;
        }
        return dist;
    }

}

