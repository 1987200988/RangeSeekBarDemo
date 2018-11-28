package com.baidu.rangeseekbardemo;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by v_liwei10 on 2018/11/19.
 */

public class LineParameter implements Parcelable {
    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float length;
    public int color;

    protected LineParameter(Parcel in) {
        length = in.readFloat();
        color = in.readInt();
    }

    public LineParameter(){
        this.length = 0;
        this.color = Color.GRAY;
    }
//
//
//
    public static final Parcelable.Creator<LineParameter> CREATOR = new Parcelable.Creator<LineParameter>() {
        @Override
        public LineParameter createFromParcel(Parcel in) {
            return new LineParameter(in);
        }

        @Override
        public LineParameter[] newArray(int size) {
            return new LineParameter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(length);
        dest.writeInt(color);
    }
}
