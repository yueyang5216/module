package com.example.yueyang.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    /**
     * 1111111
     */
    private TextView mTv;
    private String mS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        String url = "https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";
        //1,创建OkHttp对象
        OkHttpClient build = new OkHttpClient.Builder().build();
        //2，创建request请求体，请求地址和长输数据
        Request build1 = new Request.Builder()
                .url(url)
                .get()
                .build();

        Call call = build.newCall(build1);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("hahahahhahaha", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) {
                String s = null;
                try {
                    s = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                Bean bean = gson.fromJson(s, Bean.class);
                final String url1 = bean.getResults().get(0).getUrl();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTv.setText(url1);
                    }
                });
            }
        });
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
    }
}
