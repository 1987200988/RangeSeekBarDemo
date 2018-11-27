package com.baidu.rangeseekbardemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by v_liwei10 on 2018/11/19.
 */

public class RangeProgressBar extends View {

    public static final String TAG = RangeProgressBar.class.getSimpleName();
    private Paint paint;
    private float startPoint = 0;
    private float startTop = 0;
    private int lineWidth;
    private int lineHeight;
    private int outsideBorderHeight;
    private int outsideBorderWidth;
    private Paint paintOutside;
    private Paint paintScale;
    //8 140 272 404 536 668 800

    public RangeProgressBar(Context context) {
        this(context, null);
    }

    private List<LineParameter> lineParameterList = new ArrayList<>();
    private List<String> listTime = new ArrayList<>();

    public RangeProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);

        paintOutside = new Paint();
        paintOutside.setStrokeWidth(1);
        paintOutside.setStyle(Paint.Style.FILL);
        paintOutside.setAntiAlias(true);
        paintOutside.setColor(Color.GRAY);

        paintScale = new Paint();
        paintScale.setStrokeWidth(1);
        paintScale.setStyle(Paint.Style.FILL);
        paintScale.setAntiAlias(true);
        paintScale.setColor(Color.GRAY);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int w = getMeasureWidth(widthMeasureSpec);
        int h = getMeasureHeight(heightMeasureSpec);
        setMeasuredDimension(w, h);  //必须调用此方法，否则会抛出异常
    }

    /**
     * 因为View的大小不仅由View本身控制，而且受父控件的影响，所以我们在确定View大小的时候最好使用系统提供的onSizeChanged回调函数。
     * 它又四个参数，分别为 宽度，高度，上一次宽度，上一次高度。这个函数比较简单，我们只需关注 宽度(w), 高度(h) 即可，这两个参数就是View最终的大小。
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        lineWidth = 792;
        lineHeight = 32;
        outsideBorderHeight = 48;
        outsideBorderWidth = 808;
        startTop = 8;
        startPoint = 28;
        Log.e(TAG, "onSizeChanged: " + "w===" + w + "h===" + h);

    }

    public void setLineShape(List<String> list, LineParameter... lineParameters) {
        lineParameterList.clear();
        listTime.clear();
        listTime.addAll(list);
        for (LineParameter lineParameter : lineParameters) {
            lineParameterList.add(lineParameter);
        }
        invalidate();
    }

    //8 140 272 404 536 668 800
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (lineParameterList.size() == 0) {
            return;
        }
        startPoint = 28;
        //        画进度条
        for (int i = 0; i < lineParameterList.size(); i++) {
            paint.setColor(lineParameterList.get(i).color);
            canvas.drawRect(startPoint, startTop, lineParameterList.get(i).length * lineWidth + startPoint,
                    lineHeight + startTop,
                    paint);
            startPoint = startPoint + lineParameterList.get(i).length * lineWidth;
        }
        //矩形线条颜色不一致
        //canvas.drawRect(0,0,outsideBorderWidth,outsideBorderHeight,paintOutside);
        //        画外边框
        canvas.drawLine(20, 0, 20, 48, paintOutside);
        canvas.drawLine(20, 0, 828, 0, paintOutside);
        canvas.drawLine(828, 0, 828, 48, paintOutside);
        canvas.drawLine(20, 48, 828, 48, paintOutside);

        //        画刻度尺
        canvas.drawLine(28, 50, 28, 54, paintScale);
        canvas.drawLine(160, 50, 160, 54, paintScale);
        canvas.drawLine(292, 50, 292, 54, paintScale);
        canvas.drawLine(424, 50, 424, 54, paintScale);
        canvas.drawLine(556, 50, 556, 54, paintScale);
        canvas.drawLine(688, 50, 688, 54, paintScale);
        canvas.drawLine(820, 50, 820, 54, paintScale);

        //        写时间text
        canvas.drawText(listTime.get(0), 5, 68, paintScale);
        canvas.drawText(listTime.get(1), 136, 68, paintScale);
        canvas.drawText(listTime.get(2), 268, 68, paintScale);
        canvas.drawText(listTime.get(3), 400, 68, paintScale);
        canvas.drawText(listTime.get(4), 532, 68, paintScale);
        canvas.drawText(listTime.get(5), 664, 68, paintScale);
        canvas.drawText(listTime.get(6), 796, 68, paintScale);

    }

    private int getMeasureHeight(int heightMeasureSpec) {
        int result = 0;
        int size = MeasureSpec.getSize(heightMeasureSpec);  //每次调用此方法，测量用到的size会发生变化
        int mode = MeasureSpec.getMode(heightMeasureSpec);  //根据定义的Layout_width, Layout_height，会对此值产生影响
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else if (mode == MeasureSpec.UNSPECIFIED) {
            result = (int) paint.measureText("") + getPaddingLeft()
                    + getPaddingRight();
        } else {
            result = Math.min(result, size);
        }
        System.out.println("Height size:" + size);
        System.out.println("Height mode:" + mode);
        return result;
    }

    private int getMeasureWidth(int widthMeasureSpec) {
        int result = 0;
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        if (mode == MeasureSpec.EXACTLY) {
            result = size;
        } else if (mode == MeasureSpec.UNSPECIFIED) {
            result = (int) paint.measureText("") + getPaddingTop()
                    + getPaddingBottom();
        } else {
            result = Math.min(result, size);
        }
        System.out.println("Width size:" + size);
        System.out.println("Width mode:" + mode);
        return result;
    }

}
