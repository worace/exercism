import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class DNA {
    private String nucleotides;
    private static final HashSet<Character> validNucleotides = new HashSet<>();
    static {
        validNucleotides.add('A');
        validNucleotides.add('C');
        validNucleotides.add('G');
        validNucleotides.add('T');
    }

    DNA(String nucleotides) {
        this.nucleotides = nucleotides.toUpperCase();
    }

    HashMap<Character, Integer> nucleotideCounts() {
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        counts.put('A', 0);
        counts.put('C', 0);
        counts.put('G', 0);
        counts.put('T', 0);

        for (int i = 0; i < this.nucleotides.length(); i++) {
            Character tide = this.nucleotides.charAt(i);

            if(!DNA.validNucleotides.contains(tide)) {
                throw new IllegalArgumentException("Invalid Nucleotide: " + tide);
            }


            counts.put(tide, counts.getOrDefault(tide, 0) + 1);
        }
        return counts;
    }

    Integer count(Character nucleotide) {
        if(!DNA.validNucleotides.contains(nucleotide)) {
            throw new IllegalArgumentException("Invalid Nucleotide: " + nucleotide);
        }
        return this.nucleotideCounts().getOrDefault(nucleotide, 0);
    }
}
