package com.guiying.module.common.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class TestNewsBean implements Parcelable {
    public String var1;
    public String var2;

    public TestNewsBean(String var1, String var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.var1);
        dest.writeString(this.var2);
    }

    public TestNewsBean() {
    }

    protected TestNewsBean(Parcel in) {
        this.var1 = in.readString();
        this.var2 = in.readString();
    }

    public static final Creator<TestNewsBean> CREATOR = new Creator<TestNewsBean>() {
        @Override
        public TestNewsBean createFromParcel(Parcel source) {
            return new TestNewsBean(source);
        }

        @Override
        public TestNewsBean[] newArray(int size) {
            return new TestNewsBean[size];
        }
    };
}
