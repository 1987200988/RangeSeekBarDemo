package com.baidu.rangeseekbardemo;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RangeProgressBar rangeProgressBar;
    private LineParameter lineParameter;
    private LineParameter lineParameter1;
    private LineParameter lineParameter2;
    private LineParameter lineParameter3;
    private TextView textView;
    private List<String> listTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rangeProgressBar = findViewById(R.id.rangeProgressBar);
        textView = findViewById(R.id.t_1);

        lineParameter = new LineParameter();
        lineParameter1 = new LineParameter();
        lineParameter2 = new LineParameter();
        lineParameter3 = new LineParameter();
        lineParameter.length = 0.1f;
        lineParameter.color = Color.BLUE;
        lineParameter1.length = 0.2f;
        lineParameter1.color = Color.GRAY;
        lineParameter2.length = 0.3f;
        lineParameter2.color = Color.BLACK;
        lineParameter3.length = 0.4f;
        lineParameter3.color = Color.YELLOW;

        listTime = new ArrayList<>();
        listTime.add("18:30:10");
        listTime.add("19:30:10");
        listTime.add("20:30:10");
        listTime.add("12:30:10");
        listTime.add("11:30:10");
        listTime.add("10:30:10");
        listTime.add("10:30:10");

        rangeProgressBar.setLineShape(listTime,lineParameter,lineParameter1,lineParameter2,lineParameter3);

        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listTime.clear();
                listTime.add("20:00:00");
                listTime.add("20:00:01");
                listTime.add("20:00:02");
                listTime.add("20:00:03");
                listTime.add("20:00:04");
                listTime.add("20:00:05");
                listTime.add("20:00:06");
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


                rangeProgressBar.setLineShape(listTime,lineParameter,lineParameter1,lineParameter2,lineParameter3);

            }
        });

        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listTime.clear();
                listTime.add("21:00:00");
                listTime.add("22:00:01");
                listTime.add("23:00:02");
                listTime.add("24:00:03");
                listTime.add("10:00:04");
                listTime.add("10:00:05");
                listTime.add("10:00:06");
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
                rangeProgressBar.setLineShape(listTime,lineParameter,lineParameter1,lineParameter2,lineParameter3);

            }
        });

        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listTime.clear();
                listTime.add("20:10:00");
                listTime.add("20:20:01");
                listTime.add("20:30:02");
                listTime.add("20:40:03");
                listTime.add("20:50:04");
                listTime.add("20:30:05");
                listTime.add("20:40:06");
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
                rangeProgressBar.setLineShape(listTime,lineParameter,lineParameter1,lineParameter2,lineParameter3);

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
