package com.example.retrofitrequest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Contract.View {

    public static final String URL = "https://jsonplaceholder.typicode.com/";

    private TextView textResult;
    private Button button;
    List<Post> posts = new ArrayList<>();
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult = findViewById(R.id.tv_result);
        button = findViewById(R.id.button);
        presenter = new Presenter(this);

        getJsonData();

        button.setOnClickListener(v -> {
            if (posts != null)
                presenter.checkDataInPresenter(posts);
            else
                Toast.makeText(this, "Error Presenter", Toast.LENGTH_LONG).show();
        });
    }

    public void getJsonData() {
        Retrofit rft = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();

        JSONPlaceHolderAPIinterface jsonPlaceHolderAPIinterface = rft.create(JSONPlaceHolderAPIinterface.class);
        Call<List<Post>> call = jsonPlaceHolderAPIinterface.getAllUsers();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textResult.setText("Code : " + response.code());
                    return;
                }
                posts = response.body();
                if (posts != null) {
                    for (Post post : posts) {
                        String content = "";
                        content += "ID " + post.getId() + "\n";
                        content += "Title " + post.getTitle() + "\n";
                        content += "Text " + post.getText() + "\n\n";
                        textResult.append(content);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Post is NUll", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textResult.setText(t.getMessage());
            }
        });
    }

    @Override
    public void success() {
        Toast.makeText(this, "Data Successfully set in UI", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error() {
        Toast.makeText(this, "Failed to set Data in UI", Toast.LENGTH_SHORT).show();
    }
}
