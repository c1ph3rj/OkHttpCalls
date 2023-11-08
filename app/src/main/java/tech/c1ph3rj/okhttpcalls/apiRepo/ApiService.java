package tech.c1ph3rj.okhttpcalls.apiRepo;

import android.content.Context;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

public class ApiService {
    final OkHttpClient okHttpClient;
    final Context context;

    public ApiService(Context context) {
        this.context = context;
        this.okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                .build();
    }

    public Response get(String url) throws UnHandledApiException, IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try(Response response = okHttpClient.newCall(request).execute()) {
            if(response.isSuccessful()) {
                return response;
            }else {
                throw new UnHandledApiException();
            }
        }
    }
}
