package com.baidu.rangeseekbardemo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.graphics.Color;
import android.util.Log;

/**
 * Created by v_liwei10 on 2018/11/28.
 */

public class TimeProgressUtil {
    public static final String TAG = "abcdefg";
    public static String patt = "yyyy-MM-dd HH:mm:ss";
    private static String startTimeTotal = "2018-11-28 8:00:00";
    private static String endTimeTotal = "2018-11-28 12:00:00";
    public static List<LineParameter> lineList = new ArrayList<>();

    public static List<LineParameter> dataConversion(List<TestData> list) {

        lineList.clear();
        long startTotal = getStringToDate(startTimeTotal, patt);
        long endTotal = getStringToDate(endTimeTotal, patt);
        long l666 = endTotal - startTotal;
        float l = l666;

        Log.e(TAG, "dataConversion: " + l);

        for (int i = 0; i < list.size(); i++) {
            Log.e("aaaaaaaa", "dataConversion: startTime==="+list.get(i).startTime+"endTime==="+list.get(i).endTime );
            if (i == 0) {
                long startTime = list.get(i).startTime;
                if (startTime == startTotal) {
                    LineParameter lineParameter = new LineParameter();
                    lineParameter.color = Color.YELLOW;
                    long l1 = list.get(i).endTime - list.get(i).startTime;
                    float l2 = l1 / l;
                    lineParameter.length = l2;
                    Log.e(TAG, "dataConversion: " + l2);
                    lineList.add(lineParameter);

                    if(list.size()==1){
                        LineParameter lineParameter2 = new LineParameter();
                        lineParameter2.color = Color.GRAY;
                        lineParameter2.length = 1-lineParameter.length ;
                        Log.e(TAG, "dataConversion: " + l2);
                        lineList.add(lineParameter2);
                    }
                } else {
                    LineParameter lineParameter = new LineParameter();
                    lineParameter.color = Color.GRAY;
                    long l1 = list.get(i).startTime - startTotal;
                    float l2 = l1 / l;
                    lineParameter.length = l2;
                    Log.e(TAG, "dataConversion: " + l2+"l1===="+l1);
                    lineList.add(lineParameter);
                    LineParameter lineParameter2 = new LineParameter();
                    lineParameter2.color = Color.YELLOW;
                    long l12 = list.get(i).endTime - list.get(i).startTime;
                    float l22 = l12 / l;
                    lineParameter2.length = l22;
                    Log.e(TAG, "dataConversion: " + l22+"l12===="+l12);
                    lineList.add(lineParameter2);
                    if(list.size()==1){
                        LineParameter lineParameter3 = new LineParameter();
                        lineParameter3.color = Color.GRAY;
                        lineParameter3.length = 1-lineParameter.length - lineParameter2.length;
                        Log.e(TAG, "dataConversion: " + l2);

                        lineList.add(lineParameter3);
                    }
                }
            } else {
                if (i != list.size() - 1) {
                    LineParameter lineParameter = new LineParameter();
                    lineParameter.color = Color.GRAY;
                    long l3 = list.get(i).startTime - list.get(i - 1).endTime;
                    float l4 = l3 / l;
                    lineParameter.length = l4;
                    lineList.add(lineParameter);
                    Log.e(TAG, "dataConversion: " + l4);

                    LineParameter lineParameter1 = new LineParameter();
                    long l1 = list.get(i).endTime - list.get(i).startTime;
                    float l2 = l1 / l;
                    lineParameter1.color = Color.YELLOW;
                    lineParameter1.length = l2;
                    Log.e(TAG, "dataConversion: " + l2);
                    lineList.add(lineParameter1);
                } else {
                    if (list.get(i).endTime != endTotal) {

                        LineParameter lineParameter3 = new LineParameter();
                        lineParameter3.color = Color.GRAY;
                        long l5 = list.get(i).startTime - list.get(i - 1).endTime;
                        float l6 = l5 / l;
                        lineParameter3.length = l6;
                        lineList.add(lineParameter3);
                        Log.e(TAG, "dataConversion: " + l6);


                        LineParameter lineParameter1 = new LineParameter();
                        long l1 = list.get(i).endTime - list.get(i).startTime;
                        float l2 = l1 / l;
                        lineParameter1.color = Color.YELLOW;
                        lineParameter1.length = l2;
                        Log.e(TAG, "dataConversion: " + l2);
                        lineList.add(lineParameter1);

                        LineParameter lineParameter = new LineParameter();
                        lineParameter.color = Color.GRAY;
                        long l3 = endTotal - list.get(i).endTime;
                        float l4 = l3 / l;
                        lineParameter.length = l4;
                        lineList.add(lineParameter);
                        Log.e(TAG, "dataConversion: " + l4);
                    }else {


                        LineParameter lineParameter3 = new LineParameter();
                        lineParameter3.color = Color.GRAY;
                        long l5 = list.get(i).startTime - list.get(i - 1).endTime;
                        float l6 = l5 / l;
                        lineParameter3.length = l6;
                        lineList.add(lineParameter3);
                        Log.e(TAG, "dataConversion: " + l6);

                        LineParameter lineParameter1 = new LineParameter();
                        long l1 = list.get(i).endTime - list.get(i).startTime;
                        float l2 = l1 / l;
                        lineParameter1.color = Color.YELLOW;
                        lineParameter1.length = l2;
                        Log.e(TAG, "dataConversion: " + l2);
                        lineList.add(lineParameter1);
                    }
                }

            }

        }
        return lineList;


    }

    //    将时间戳转为字符串

    public static String getDateToString(long milSecond, String pattern) {
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
    //    将字符串转为时间戳

    public static long getStringToDate(String dateString, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();

        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }

}
