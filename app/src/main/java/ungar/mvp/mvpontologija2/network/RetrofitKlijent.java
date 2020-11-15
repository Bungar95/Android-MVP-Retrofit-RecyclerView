package ungar.mvp.mvpontologija2.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitKlijent {

    private static Retrofit retrofit;
    public static final String REST_URL="https://oziz.ffos.hr/nastava20192020/bungar_19/ontologija/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(REST_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
