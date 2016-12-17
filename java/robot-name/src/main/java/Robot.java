import java.util.Random;

public class Robot {
    String name;

    static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static char[] digits = "0123456789".toCharArray();

    static char randNth(char[] coll) {
        return coll[new Random().nextInt(coll.length)];
    }

    static char letter() { return randNth(alphabet); }

    static char digit() { return randNth(digits); }

    private String generateName(String existingName) {
        String newName = randomName();
        while(newName.equals(existingName)) {
            newName = randomName();
        }
        return newName;
    }

    private String generateName() {
        return randomName();
    }

    private String randomName() {
        char[] name = {Robot.letter(), Robot.letter(),
                Robot.digit(), Robot.digit(), Robot.digit()};
        return new String(name);
    }

    public Robot() {
        this.name = this.generateName();
    }

    public String getName() {
        return this.name;
    }

    public void reset() {
        this.name = generateName(this.name);
    }
}
