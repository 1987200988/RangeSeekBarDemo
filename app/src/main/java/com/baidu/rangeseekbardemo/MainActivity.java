package com.baidu.rangeseekbardemo;

import java.util.ArrayList;
import java.util.List;

import com.baidu.rangeseekbardemo.databinding.ActivityMainBinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RangeProgressBar rangeProgressBar;
    private LineParameter lineParameter;
    private LineParameter lineParameter1;
    private LineParameter lineParameter2;
    private LineParameter lineParameter3;
    private TextView textView;
    private List<String> listTime = new ArrayList<>();
    private ObservableArrayList<LineParameter> list;
    private ObservableArrayList<String> time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //        setContentView(R.layout.activity_main);

        lineParameter = new LineParameter();
        lineParameter1 = new LineParameter();
        lineParameter2 = new LineParameter();
        lineParameter3 = new LineParameter();
        lineParameter.length = 0.2f;
        lineParameter.color = Color.GRAY;
        lineParameter1.length = 0.1f;
        lineParameter1.color = Color.BLUE;
        lineParameter2.length = 0.4f;
        lineParameter2.color = Color.BLACK;
        lineParameter3.length = 0.3f;
        lineParameter3.color = Color.YELLOW;
        list = new ObservableArrayList<LineParameter>();
        list.add(lineParameter);
        list.add(lineParameter1);
        list.add(lineParameter2);
        list.add(lineParameter3);

        time = new ObservableArrayList<>();
        time.add("18:30:10");
        time.add("19:30:10");
        time.add("20:30:10");
        time.add("12:30:10");
        time.add("11:30:10");
        time.add("10:30:10");
        time.add("10:30:10");


        activityMainBinding.setMyData(list);
        activityMainBinding.setData(time);

        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.clear();
                time.add("20:00:00");
                time.add("20:00:01");
                time.add("20:00:02");
                time.add("20:00:03");
                time.add("20:00:04");
                time.add("20:00:05");
                time.add("20:00:06");
                lineParameter = new LineParameter();
                lineParameter1 = new LineParameter();
                lineParameter2 = new LineParameter();
                lineParameter3 = new LineParameter();
                lineParameter.length = 0.2f;
                lineParameter.color = Color.BLACK;
                lineParameter1.length = 0.1f;
                lineParameter1.color = Color.GRAY;
                lineParameter2.length = 0.4f;
                lineParameter2.color = Color.GREEN;
                lineParameter3.length = 0.3f;
                lineParameter3.color = Color.YELLOW;

                list.clear();
                list.add(lineParameter);
                list.add(lineParameter1);
                list.add(lineParameter2);
                list.add(lineParameter3);

            }
        });

        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.clear();
                time.add("21:00:00");
                time.add("22:00:01");
                time.add("23:00:02");
                time.add("24:00:03");
                time.add("10:00:04");
                time.add("10:00:05");
                time.add("10:00:06");
                lineParameter = new LineParameter();
                lineParameter1 = new LineParameter();
                lineParameter2 = new LineParameter();
                lineParameter3 = new LineParameter();
                lineParameter.length = 0.1f;
                lineParameter.color = Color.BLUE;
                lineParameter1.length = 0.3f;
                lineParameter1.color = Color.GRAY;
                lineParameter2.length = 0.2f;
                lineParameter2.color = Color.BLACK;
                lineParameter3.length = 0.4f;
                lineParameter3.color = Color.GREEN;
                list.clear();
                list.add(lineParameter);
                list.add(lineParameter1);
                list.add(lineParameter2);
                list.add(lineParameter3);
            }
        });

        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.clear();
                time.add("20:10:00");
                time.add("20:20:01");
                time.add("20:30:02");
                time.add("20:40:03");
                time.add("20:50:04");
                time.add("20:30:05");
                time.add("20:40:06");
                lineParameter = new LineParameter();
                lineParameter1 = new LineParameter();
                lineParameter2 = new LineParameter();
                lineParameter3 = new LineParameter();
                lineParameter.length = 0.1f;
                lineParameter.color = Color.YELLOW;
                lineParameter1.length = 0.2f;
                lineParameter1.color = Color.GRAY;
                lineParameter2.length = 0.3f;
                lineParameter2.color = Color.BLACK;
                lineParameter3.length = 0.4f;
                lineParameter3.color = Color.GREEN;
                list.clear();
                list.add(lineParameter);
                list.add(lineParameter1);
                list.add(lineParameter2);
                list.add(lineParameter3);
            }
        });

        //        rangeProgressBar.setOnRangeChangedListener(new RangeSeekBar.OnRangeChangedListener() {
        //            @Override
        //            public void onRangeChanged(RangeSeekBar view, float min, float max) {
        //                textView.setText("min="+min+"max="+max);
        //                if (min > 0.1 && max > 0.5) {
        //                    lineParameter = new LineParameter();
        //                    lineParameter1 = new LineParameter();
        //                    lineParameter2 = new LineParameter();
        //                    lineParameter3 = new LineParameter();
        //                    lineParameter.length = 0.1f;
        //                    lineParameter.color = Color.BLUE;
        //                    lineParameter1.length = 0.2f;
        //                    lineParameter1.color = Color.GRAY;
        //                    lineParameter2.length = 0.3f;
        //                    lineParameter2.color = Color.BLACK;
        //                    lineParameter3.length = 0.4f;
        //                    lineParameter3.color = Color.YELLOW;
        //                }else if(min==0&&max==0){
        //                    lineParameter = new LineParameter();
        //                    lineParameter1 = new LineParameter();
        //                    lineParameter2 = new LineParameter();
        //                    lineParameter3 = new LineParameter();
        //                    lineParameter.length = 0.5f;
        //                    lineParameter.color = Color.BLACK;
        //                    lineParameter1.length = 0.2f;
        //                    lineParameter1.color = Color.BLACK;
        //                    lineParameter2.length = 0.2f;
        //                    lineParameter2.color = Color.BLACK;
        //                    lineParameter3.length = 0.1f;
        //                    lineParameter3.color = Color.BLACK;
        //
        //                }else if(min==0&&max>0.1&&max<0.3){
        //                    lineParameter = new LineParameter();
        //                    lineParameter1 = new LineParameter();
        //                    lineParameter2 = new LineParameter();
        //                    lineParameter3 = new LineParameter();
        //                    lineParameter.length = 0.3f;
        //                    lineParameter.color = Color.GRAY;
        //                    lineParameter1.length = 0.2f;
        //                    lineParameter1.color = Color.BLUE;
        //                    lineParameter2.length = 0.1f;
        //                    lineParameter2.color = Color.BLACK;
        //                    lineParameter3.length = 0.4f;
        //                    lineParameter3.color = Color.BLACK;
        //                }else {
        //                    lineParameter = new LineParameter();
        //                    lineParameter1 = new LineParameter();
        //                    lineParameter2 = new LineParameter();
        //                    lineParameter3 = new LineParameter();
        //                    lineParameter.length = 0.6f;
        //                    lineParameter.color = Color.YELLOW;
        //                    lineParameter1.length = 0.3f;
        //                    lineParameter1.color = Color.BLUE;
        //                    lineParameter2.length = 0.05f;
        //                    lineParameter2.color = Color.BLACK;
        //                    lineParameter3.length = 0.05f;
        //                    lineParameter3.color = Color.YELLOW;
        //                }
        //
        //                rangeProgressBar.setLineShape(lineParameter, lineParameter1, lineParameter2, lineParameter3);
        //
        //            }
        //        });

    }

}
