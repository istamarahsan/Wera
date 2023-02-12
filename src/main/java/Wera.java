import io.javalin.Javalin;

public class Wera {
    
    private final Javalin javalinApp;

    private Wera(Javalin javalinApp) {
        this.javalinApp = javalinApp;
    }
    
    public static Wera createAndStart(int port) {
        var javalin = Javalin.create().start(port);
        mapEndpoints(javalin);
        return new Wera(javalin);
    }

    public static Wera create() {
        var javalin = Javalin.create();
        mapEndpoints(javalin);
        return new Wera(javalin);
    }
    
    public Javalin javalinApp() {
        return this.javalinApp;
    }
    
    private static void mapEndpoints(Javalin javalin) {
        // map endpoints here
    }
}
