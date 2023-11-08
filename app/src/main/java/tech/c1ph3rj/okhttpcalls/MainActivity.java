package tech.c1ph3rj.okhttpcalls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tech.c1ph3rj.okhttpcalls.apiRepo.ApiService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = new ApiService(this);
        try {
            apiService.get("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}