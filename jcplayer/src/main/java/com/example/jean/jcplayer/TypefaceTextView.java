package com.example.jean.jcplayer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;


public class TypefaceTextView extends AppCompatTextView {

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public TypefaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context, attrs);

    }

    public TypefaceTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        TypedArray attributeArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.TypefaceTextView);

        String fontName = attributeArray.getString(R.styleable.TypefaceTextView_font);
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);

        Typeface customFont = selectTypeface(context, fontName, textStyle);
        setTypeface(customFont);

        attributeArray.recycle();
    }

    private Typeface selectTypeface(Context context, String fontName, int textStyle) {
        if (TextUtils.isEmpty(fontName)) {
            return FontCache.getTypeface("Roboto-Regular.ttf", context);
        }
        if (fontName.contentEquals(context.getString(R.string.font_roboto_bold))) {
            return FontCache.getTypeface("Roboto-Bold.ttf", context);
        } else if (fontName.contentEquals(context.getString(R.string.font_roboto_light))) {
            return FontCache.getTypeface("Roboto-Light.ttf", context);
        } else if (fontName.contentEquals(context.getString(R.string.font_roboto_regular))) {
            return FontCache.getTypeface("Roboto-Regular.ttf", context);
        } else if (fontName.contentEquals(context.getString(R.string.font_roboto_medium))) {
            return FontCache.getTypeface("Roboto-Medium.ttf", context);
        } else {
            return null;
        }
    }

}
