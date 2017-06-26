package com.example.jean.jcplayer;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;

/**
 * Class containing constants related to Fonts used by the app. This class is also used to initialize
 * fonts. The class uses LRUCache to store and retrieve fonts, for faster access.
 */
public class FontFactory {

    private Typeface robotoLightFont;
    private Typeface robotoLightItalicFont;
    private Typeface robotoMediumFont;
    private Typeface robotoRegularFont;
    private Typeface savoyeFont;
    private Typeface fontHelvetical;
    private Typeface openSansRegular;
    private Typeface openSansBold;
    private Typeface openSansItalicBold;

    private static final int FONT_ROBOTO_LIGHT = 0;
    private static final int FONT_ROBOTO_LIGHT_ITALIC = 1;
    private static final int FONT_ROBOTO_MEDIUM = 2;
    private static final int FONT_ROBOTO_REGULAR = 3;
    private static final int FONT_ROBOTO_THIN = 4;
    private static final int FONT_SAVOYE = 5;
    private static final int FONT_HELVETICAL = 6;
    private static final int FONT_OPEN_SANS_REGULAR = 7;
    private static final int FONT_OPEN_SANS_BOLD = 8;
    private static final int FONT_OPEN_SANS_ITALICS_BOLD = 9;

    private static FontFactory factory;

    /**
     * Function to ensure a single instance of FontFactory class
     *
     * @return FontFactory class instance
     */
    public static FontFactory getInstance() {
        if (factory == null) {
            factory = new FontFactory();
        }
        return factory;
    }

    /**
     * Function to initialize Typeface object using the type information.
     *
     * @param ctx  Context instance
     * @param type Int containing Font type information eg. FONT_ROBOTO_LIGHT,
     *             FONT_ROBOTO_LIGHT_ITALIC, FONT_ROBOTO_MEDIUM, etc
     * @return Typeface object containing Font, if type sent match a defined font
     */
    public Typeface getFont(Context ctx, int type) {
        switch (type) {
            case FONT_ROBOTO_LIGHT:
                if (robotoLightFont == null) {
                    robotoLightFont = Typeface.createFromAsset(ctx.getAssets(),
                            "Roboto-Light.ttf");
                }
                return robotoLightFont;

            case FONT_ROBOTO_LIGHT_ITALIC:
                if (robotoLightItalicFont == null) {
                    robotoLightFont = Typeface.createFromAsset(ctx.getAssets(),
                            "Roboto-LightItalic.ttf");
                }
                return robotoLightItalicFont;

            case FONT_ROBOTO_MEDIUM:
                if (robotoMediumFont == null) {
                    robotoMediumFont = Typeface.createFromAsset(ctx.getAssets(),
                            "Roboto-Medium.ttf");
                }
                return robotoMediumFont;

            case FONT_ROBOTO_REGULAR:
                if (robotoRegularFont == null) {
                    robotoRegularFont = Typeface.createFromAsset(ctx.getAssets(),
                            "Roboto-Regular.ttf");
                }
                return robotoRegularFont;

            case FONT_ROBOTO_THIN:
                if (robotoRegularFont == null) {
                    robotoRegularFont = Typeface.createFromAsset(ctx.getAssets(),
                            "Roboto-Thin.ttf");
                }
                return robotoRegularFont;

            case FONT_SAVOYE:
                if (savoyeFont == null) {
                    savoyeFont = Typeface.createFromAsset(ctx.getAssets(),
                            "Savoye_LET.ttc");
                }
                return savoyeFont;

            case FONT_HELVETICAL:
                if (fontHelvetical == null) {
                    fontHelvetical = Typeface.createFromAsset(ctx.getAssets(),
                            "Helvetical.otf");
                }
                return fontHelvetical;

            case FONT_OPEN_SANS_REGULAR:
                if (openSansRegular == null) {
                    openSansRegular = Typeface.createFromAsset(ctx.getAssets(),
                            "OpenSans-Regular.ttf");
                }
                return openSansRegular;
            case FONT_OPEN_SANS_BOLD:
                if (openSansBold == null) {
                    openSansBold = Typeface.createFromAsset(ctx.getAssets(),
                            "OpenSans-Bold.ttf");
                }
                return openSansBold;
            case FONT_OPEN_SANS_ITALICS_BOLD:
                if (openSansItalicBold == null) {
                    openSansItalicBold = Typeface.createFromAsset(ctx.getAssets(),
                            "OpenSans-BoldItalic.ttf");
                }
                return openSansItalicBold;
            default:
                break;
        }
        return null;
    }


    /**
     * LRUCache is used to store Typeface in cache using a String as the 'key'
     */
    private static LruCache<String, Typeface> fontCache = new LruCache<>(5);

    /**
     * Function to get TypeFace using the font name.
     *
     * @param ctx      Context instance
     * @param fontName Name of the font to be loaded
     * @return TypeFace containing the font information, if font was loaded successfully.
     */
    public Typeface getFont(Context ctx, String fontName) {
        Typeface tf = fontCache.get(fontName);
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(ctx.getAssets(), fontName);
            } catch (Exception e) {
                return null;
            }
            fontCache.put(fontName, tf);
        }
        return tf;
    }

}

