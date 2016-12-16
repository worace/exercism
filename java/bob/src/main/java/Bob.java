
public class Bob {
    private Boolean noLetters(String message) {
        return message.replaceAll("[^A-Za-z]", "").isEmpty();
    }

    private Boolean isShouting(String message) {
        return !noLetters(message) && message.toUpperCase().equals(message);
    }

    private Boolean isQuestion(String message) {
        return message.endsWith("?");
    }

    private Boolean isSilent(String message) {
        return message.replaceAll(" ", "").isEmpty();
    }

    public String hey(String message) {
        if (isShouting(message)) {
            return "Whoa, chill out!";
        } else if (isQuestion(message)) {
            return "Sure.";
        } else if (isSilent(message)) {
            return "Fine. Be that way!";
        } else {
            return "Whatever.";
        }
    }
}
