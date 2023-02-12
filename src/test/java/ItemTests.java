import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ItemTests {
    private final Javalin app = Wera.create().javalinApp();
    private final Gson gson = new Gson();
    
    @Test
    public void responseIsValidItemSchema() {
        var endpoint = "/generate/item";
        String[] expectedFields = {"name", "description"};
        JavalinTest.test(app, (server, client) -> {
            var responseString = client.get(endpoint).body().string();
            Map<String, String> stringMap = gson.fromJson(responseString, new TypeToken<>() {});
            for (var fieldName:expectedFields) {
                Assertions.assertThat(stringMap.containsKey(fieldName)).isTrue();
            }
        });
    }
}
