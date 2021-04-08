package homework6;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class WeatherForecast {

    private static final String APIKEY = "c8f482a3-fd5b-49a4-91a6-cae370aadd20";

    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        MediaType JSON = MediaType.parse("JSON");

        Request request = new Request.Builder()
                .url("https://api.weather.yandex.ru/v2/forecast?")
                .addHeader("accept", "application/json")
                .addHeader("X-Yandex-API-Key",APIKEY)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String body = response.body().string();
        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(body);

    }
}
