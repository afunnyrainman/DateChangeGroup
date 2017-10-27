package com.example.administrator.datechangegroup;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DXQ on 2017/10/24 0024.
 */

public class DateChangeView extends RelativeLayout {
    /**
     * 记录数据
     */
    private Map<Integer, String> vMap = new HashMap<>();

    public DateChangeView(Context context) {
        super(context);
    }

    public DateChangeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DateChangeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DateChangeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setListenerEnabled(View v) {
        this.setViewState(v);
    }

    private void setViewState(View child) {
        if (child instanceof RadioGroup) {
            RadioGroup radioGroup = (RadioGroup) child;
            vMap.put(child.getId(), radioGroup.getCheckedRadioButtonId() + "");
        }
        if (child instanceof EditText) {
            EditText editText = (EditText) child;
            if (null != editText.getText()) {
                vMap.put(child.getId(), editText.getText().toString());
            } else {
                vMap.put(child.getId(), "null");
            }
        }

        if (child instanceof ViewGroup) {
            ViewGroup var4 = (ViewGroup) child;
            for (int j = 0; j < var4.getChildCount(); j++) {
                this.setViewState(var4.getChildAt(j));
            }
        }
    }

    public boolean getViewState(View child) {
        if (child instanceof RadioGroup) {
            RadioGroup radioGroup = (RadioGroup) child;
            if (null != vMap.get(child.getId())) {
                if (!vMap.get(child.getId()).equals(radioGroup.getCheckedRadioButtonId() + "")) {
                    return true;
                }
            }
        }

        if (child instanceof EditText) {
            EditText editText = (EditText) child;
            if (null != vMap.get(child.getId())) {
                if (!vMap.get(child.getId()).equals(editText.getText().toString())) {
                    return true;
                }
            }
        }

        if (child instanceof ViewGroup) {
            ViewGroup var4 = (ViewGroup) child;
            for (int j = 0; j < var4.getChildCount(); j++) {
                if(this.getViewState(var4.getChildAt(j))){
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
    }

}
