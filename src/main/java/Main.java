import java.util.Optional;

public class Main {
    
    private static final int defaultPort = 8080;
    
    public static void main(String[] args) {
        var port = Optional.ofNullable(System.getenv("PORT"))
                .flatMap(Main::tryParseString)
                .orElse(defaultPort);
        
        Wera.createAndStart(port);
    }
    
    private static Optional<Integer> tryParseString(String str) {
        Optional<Integer> result;
        try {
           result = Optional.of(Integer.valueOf(str)); 
        } catch (NumberFormatException e) {
           result = Optional.empty(); 
        }
        return result;
    }
}
