package chenghuimin.bwie.com.week01;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.找控件
       toolbar = findViewById(R.id.toolbar);

        //2.设置toolbar
        setSupportActionBar(toolbar);

        //3.设置是否显示主标题
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //4.设置主标题
        getSupportActionBar().setTitle("课时作业");
        toolbar.setTitleMargin(10,0,10,10);

        //5.设置主标题的颜色
        toolbar.setTitleTextColor(Color.GRAY);

        //6.设置是否显示左侧的按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //7.设置按钮得点击事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

    }

    //创建
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //准备
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }


    //选中
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void closeOptionsMenu() {
        super.closeOptionsMenu();
    }
}
