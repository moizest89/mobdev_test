package moizest89.mobdev_test.remote;


import android.content.Context;

import moizest89.mobdev_test.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by moizest89 on 2/24/18.
 */

public class MobdevTestClient {

    public final static String baseURL = BuildConfig.api_service_url;
    public final static String LOG = MobdevTestClient.class.getSimpleName();

    private static ApiService apiService;

    public static  ApiService getClient(){

        if(apiService == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor);

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService = client.create(ApiService.class);
        }

        return apiService;
    }
}
