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
    private ObservableArrayList<LineParameter> list = new ObservableArrayList<>();
    private ObservableArrayList<String> time = new ObservableArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //        setContentView(R.layout.activity_main);

        //        模拟数据接口返回的时间数据
        TestData testData = new TestData();
        testData.startTime = TimeProgressUtil.getStringToDate("2018-11-28 8:00:00", TimeProgressUtil.patt);
        testData.endTime = TimeProgressUtil.getStringToDate("2018-11-28 8:50:00", TimeProgressUtil.patt);
        Log.e("abcd", "onCreate: startTime==="+testData.startTime+"endTime==="+testData.endTime );
//        TestData testData1 = new TestData();
//        testData1.startTime = TimeProgressUtil.getStringToDate("2018-11-28 9:10:00", TimeProgressUtil.patt);
//        testData1.endTime = TimeProgressUtil.getStringToDate("2018-11-28 9:50:00", TimeProgressUtil.patt);
//        TestData testData2 = new TestData();
//        testData2.startTime = TimeProgressUtil.getStringToDate("2018-11-28 9:55:00", TimeProgressUtil.patt);
//        testData2.endTime = TimeProgressUtil.getStringToDate("2018-11-28 10:00:00", TimeProgressUtil.patt);
//        TestData testData3 = new TestData();
//        testData3.startTime = TimeProgressUtil.getStringToDate("2018-11-28 11:10:00", TimeProgressUtil.patt);
//        testData3.endTime = TimeProgressUtil.getStringToDate("2018-11-28 11:30:00", TimeProgressUtil.patt);

        List listTest = new ArrayList<TestData>();
        listTest.add(testData);
//        listTest.add(testData1);
//        listTest.add(testData2);
//        listTest.add(testData3);
        //        模拟数据接口返回的时间数据



        time.add("18:30:10");
        time.add("19:30:10");
        time.add("20:30:10");
        time.add("12:30:10");
        time.add("11:30:10");
        time.add("10:30:10");
        time.add("10:30:10");
        //

        List dataConversion = TimeProgressUtil.dataConversion(listTest);

        //                判断总进度是否为1 测试时候用的方法
        getTotalProgress(dataConversion);

        this.list.addAll(dataConversion);
        activityMainBinding.setMyData(this.list);
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
                //        模拟数据接口返回的时间数据
                TestData testData = new TestData();
                testData.startTime = TimeProgressUtil.getStringToDate("2018-11-28 8:50:00", TimeProgressUtil.patt);
                testData.endTime = TimeProgressUtil.getStringToDate("2018-11-28 8:55:00", TimeProgressUtil.patt);
                TestData testData1 = new TestData();
                testData1.startTime = TimeProgressUtil.getStringToDate("2018-11-28 9:30:00", TimeProgressUtil.patt);
                testData1.endTime = TimeProgressUtil.getStringToDate("2018-11-28 9:50:00", TimeProgressUtil.patt);
                TestData testData2 = new TestData();
                testData2.startTime = TimeProgressUtil.getStringToDate("2018-11-28 9:55:00", TimeProgressUtil.patt);
                testData2.endTime = TimeProgressUtil.getStringToDate("2018-11-28 10:30:00", TimeProgressUtil.patt);
                TestData testData3 = new TestData();
                testData3.startTime = TimeProgressUtil.getStringToDate("2018-11-28 11:10:00", TimeProgressUtil.patt);
                testData3.endTime = TimeProgressUtil.getStringToDate("2018-11-28 12:00:00", TimeProgressUtil.patt);

                List listTest = new ArrayList<TestData>();
                listTest.add(testData);
                listTest.add(testData1);
                listTest.add(testData2);
                listTest.add(testData3);

                //        模拟数据接口返回的时间数据



                List<LineParameter> test = TimeProgressUtil.dataConversion(listTest);
                //                判断总进度是否为1 测试时候用的方法
                getTotalProgress(test);
                MainActivity.this.list.clear();
                MainActivity.this.list.addAll(test);

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
                //        模拟数据接口返回的时间数据
                TestData testData = new TestData();
                testData.startTime = TimeProgressUtil.getStringToDate("2018-11-28 8:00:00", TimeProgressUtil.patt);
                testData.endTime = TimeProgressUtil.getStringToDate("2018-11-28 8:55:00", TimeProgressUtil.patt);
                TestData testData1 = new TestData();
                testData1.startTime = TimeProgressUtil.getStringToDate("2018-11-28 9:30:00", TimeProgressUtil.patt);
                testData1.endTime = TimeProgressUtil.getStringToDate("2018-11-28 9:50:00", TimeProgressUtil.patt);
                TestData testData2 = new TestData();
                testData2.startTime = TimeProgressUtil.getStringToDate("2018-11-28 9:55:00", TimeProgressUtil.patt);
                testData2.endTime = TimeProgressUtil.getStringToDate("2018-11-28 10:30:00", TimeProgressUtil.patt);
                TestData testData3 = new TestData();
                testData3.startTime = TimeProgressUtil.getStringToDate("2018-11-28 11:10:00", TimeProgressUtil.patt);
                testData3.endTime = TimeProgressUtil.getStringToDate("2018-11-28 12:00:00", TimeProgressUtil.patt);

                List listTest = new ArrayList<TestData>();
                listTest.add(testData);
                listTest.add(testData1);
                listTest.add(testData2);
                listTest.add(testData3);

                //        模拟数据接口返回的时间数据



                List<LineParameter> test = TimeProgressUtil.dataConversion(listTest);
                //                判断总进度是否为1 测试时候用的方法
                getTotalProgress(test);
                MainActivity.this.list.clear();
                MainActivity.this.list.addAll(test);
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
                //        模拟数据接口返回的时间数据
                TestData testData = new TestData();
                testData.startTime = TimeProgressUtil.getStringToDate("2018-11-28 8:00:00", TimeProgressUtil.patt);
                testData.endTime = TimeProgressUtil.getStringToDate("2018-11-28 8:55:00", TimeProgressUtil.patt);
                TestData testData1 = new TestData();
                testData1.startTime = TimeProgressUtil.getStringToDate("2018-11-28 9:30:00", TimeProgressUtil.patt);
                testData1.endTime = TimeProgressUtil.getStringToDate("2018-11-28 9:50:00", TimeProgressUtil.patt);
                TestData testData2 = new TestData();
                testData2.startTime = TimeProgressUtil.getStringToDate("2018-11-28 9:55:00", TimeProgressUtil.patt);
                testData2.endTime = TimeProgressUtil.getStringToDate("2018-11-28 10:30:00", TimeProgressUtil.patt);
                TestData testData3 = new TestData();
                testData3.startTime = TimeProgressUtil.getStringToDate("2018-11-28 11:50:00", TimeProgressUtil.patt);
                testData3.endTime = TimeProgressUtil.getStringToDate("2018-11-28 12:00:00", TimeProgressUtil.patt);

                List listTest = new ArrayList<TestData>();
                listTest.add(testData);
                listTest.add(testData1);
                listTest.add(testData2);
                listTest.add(testData3);



                //        模拟数据接口返回的时间数据
                List<LineParameter> test = TimeProgressUtil.dataConversion(listTest);
                //                判断总进度是否为1 测试时候用的方法
                getTotalProgress(test);
                MainActivity.this.list.clear();
                MainActivity.this.list.addAll(test);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void getTotalProgress(List<LineParameter> dataConversion) {
        float a = 0;
        for (int i = 0; i < dataConversion.size(); i++) {
            Log.e("abcd", "onCreate: " + dataConversion.get(i).length);
            a = a + dataConversion.get(i).length;
        }
        Log.e("abcd", "a======: " + a);

    }

}
