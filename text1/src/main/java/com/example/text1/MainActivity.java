package com.example.text1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    /**
     * 111111111
     */
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        String str="http://api.shujuzhihui.cn/api/news/list?";
        //1，创建OkhTTP对象
        OkHttpClient build = new OkHttpClient.Builder()
                .build();
        //创建RequestBody   项数据库窗残的对象
        RequestBody build1 = new FormBody.Builder()
                .add("appKey", "54cfa75fa4d44834857cd9b4813a221f")
                .add("category", "要闻")
                .add("page", "1")
                .build();
        //创建请求对像
        Request builder = new Request.Builder()
                .url(str)
                .post(build1)
                .build();
        //用OK对象进行数据毁掉
        Call call = build.newCall(builder);
        //惊醒异步加载
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Gson gson = new Gson();
                Bean bean = gson.fromJson(string.toString(), Bean.class);
                final List<Bean.RESULTBean.NewsListBean> newsList = bean.getRESULT().getNewsList();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String title = newsList.get(0).getTitle();
                        mTv.setText(title);
                    }
                });
            }
        });
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
    }
}
