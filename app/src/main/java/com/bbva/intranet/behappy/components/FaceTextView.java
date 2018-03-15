package com.bbva.intranet.behappy.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.utils.Utils;

public class FaceTextView extends AppCompatTextView {

    public FaceTextView(Context context) {
        super(context);
        init(null, 0);
    }

    public FaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public FaceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FaceTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    public void init(AttributeSet attrs, int defStyle) {

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/Lato-Regular.ttf");

        int style;

        if (getTypeface() != null) {
            style = getTypeface().getStyle();
        } else {
            style = 0;
        }
        if (isInEditMode()) {
            return;
        }
        TypedArray typedAry = getContext().obtainStyledAttributes(attrs,
                R.styleable.FaceTextView, defStyle, 0);
        String fontFace = typedAry.getString(R.styleable.FaceTextView_typeface);

        if (fontFace != null) {
            typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontFace);
        }
        setTypeface(typeface, style);

        boolean underline = typedAry.getBoolean(R.styleable.FaceTextView_underline, false);

        if (underline) {
            setPaintFlags(getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }

        if (defStyle != 0) {
            int[] set = {
                    android.R.attr.textSize
            };
            TypedArray defTa = getContext().obtainStyledAttributes(defStyle, set);

            int dim = defTa.getDimensionPixelOffset(0, Utils.dpToPixels(getContext(), 12));
            setTextSize(TypedValue.COMPLEX_UNIT_PX, dim);

            defTa.recycle();
        }
        typedAry.recycle();
    }

    public void setFontFace(String fontFace) {
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),"fonts/" + fontFace);
        setFontFace(typeface);
    }


    public void setFontFace(Typeface fontFace) {
        int style;

        if (getTypeface() != null) {
            style = getTypeface().getStyle();
        } else {
            style = 0;
        }

        setTypeface(fontFace, style);
    }
}