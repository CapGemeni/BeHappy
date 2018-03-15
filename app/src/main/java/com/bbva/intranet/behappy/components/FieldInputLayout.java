package com.bbva.intranet.behappy.components;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.bbva.intranet.behappy.R;


public class FieldInputLayout extends TextInputLayout {

    public FieldInputLayout(Context context) {
        super(context);
        init();
    }

    public FieldInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FieldInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        setHintTextAppearance(R.style.Text_Gray);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Regular.ttf");
        setTypeface(typeface);
    }


    @Override
    public void setError(CharSequence error) {
        super.setError(error);
        requestFocus();
        if(error == null){
            setErrorEnabled(false);
        }
        if (TextUtils.isEmpty(error)) {
            return;
        }
        setErrorEnabled(true);
    }
}