package com.bbva.intranet.behappy.components;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;

public class FieldInputEditText extends TextInputEditText {

    private TextWatcher inWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //unused
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //unused
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (getParent() != null) {
                View parent = (View) getParent().getParent();
                if (parent != null) {
                    if (parent instanceof FieldInputLayout) {
                        ((FieldInputLayout) parent).setError(null);
                    } else if (parent instanceof TextInputLayout) {
                        ((TextInputLayout) parent).setError(null);
                    } else {
                        setError(null);
                    }
                } else {
                    setError(null);
                }
            }
        }
    };



    public FieldInputEditText(Context context) {
        super(context);
        init();
    }

    public FieldInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FieldInputEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    protected void init(){
        addTextChangedListener(inWatcher);

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Lato-Regular.ttf");

        int style;
        if (getTypeface() != null) {
            style = getTypeface().getStyle();
        } else {
            style = 0;
        }
        setTypeface(typeface, style);
    }
}