public class HelloWorld {
    public static String hello(String name) {
        if (name == null) {
            return "Hello, World!";
        } else if (name == "") {
            return "Hello, World!";
        }
        else {
            return "Hello, " + name + "!";
        }
    }
}
