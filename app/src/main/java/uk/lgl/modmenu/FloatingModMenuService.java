/*
 * Credit:
 *
 * Octowolve - Mod menu: https://github.com/z3r0Sec/Substrate-Template-With-Mod-Menu
 * And hooking: https://github.com/z3r0Sec/Substrate-Hooking-Example
 * VanHoevenTR A.K.A Nixi: https://github.com/LGLTeam/VanHoevenTR_Android_Mod_Menu
 * MrIkso - Mod menu: https://github.com/MrIkso/FloatingModMenu
 * Rprop - https://github.com/Rprop/And64InlineHook
 * MJx0 A.K.A Ruit - KittyMemory: https://github.com/MJx0/KittyMemory
 * */

package uk.lgl.modmenu;

import android.animation.ArgbEvaluator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.PorterDuff;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.MotionEvent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.view.View;
import android.view.WindowManager;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.animation.ArgbEvaluator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.PorterDuff;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.MotionEvent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.view.View;
import android.view.WindowManager;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.lang.String;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.lang.String;

import static uk.lgl.modmenu.StaticActivity.cacheDir;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.widget.RelativeLayout.ALIGN_PARENT_RIGHT;

public class FloatingModMenuService extends Service {
    private final String TAG = "Mod_Menu"; //Tag for logcat
    private final int TEXT_COLOR = Color.parseColor("#82CAFD");
    private final int TEXT_COLOR_2 = Color.parseColor("#FFFFFF");
    private final int BTN_COLOR = Color.parseColor("#000000");
    private final int MENU_BG_COLOR = Color.parseColor("#000000"); //#AARRGGBB
    private final int MENU_FEATURE_BG_COLOR = Color.parseColor("#000000"); //#AARRGGBB
    private final int MENU_WIDTH = 230;
    private final int MENU_HEIGHT = 230;
    private final float MENU_CORNER = 50f;
    private final int ICON_SIZE = 50;
    private final float ICON_ALPHA = 0.7f; //Transparent
    private MediaPlayer FXPlayer;
    public View mFloatingView;
    private Button close;
    private LinearLayout mButtonPanel;
    public RelativeLayout mCollapsed;
    public LinearLayout mExpanded, patches, mSettings;
    private RelativeLayout mRootContainer;
    public WindowManager mWindowManager;
    private WindowManager.LayoutParams espParams;
    private ESPView overlayView;
    public WindowManager.LayoutParams params;
    private FrameLayout rootFrame;
    private LinearLayout Btns;
    private LinearLayout Btns2;
    private ImageView startimage, startimage2;
    private LinearLayout view1;

    LinearLayout.LayoutParams scrlLLExpanded, scrlLL;

    private AlertDialog alert;
    private EditText edittextvalue;

    //initialize methods from the native library
    public static native String Toast();

    private GradientDrawable gdMenuBody, gdAnimation = new GradientDrawable();

    private native String Title();

    private native String Heading();

    private native String Icon();

    public static native void DrawOn(ESPView espView, Canvas canvas);

    private native String IconWebViewData();

    private native boolean EnableSounds();

    private native int IconSize();

    public native void Changes(int feature, int value);

    private native String[] getFeatureList();

    private int getLayoutType() {
        if (Build.VERSION.SDK_INT >= 26) {
            return 2038;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return 2002;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return 2005;
        }
        return 2003;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //Override our Start Command so the Service doesnt try to recreate itself when the App is closed
    public int onStartCommand(Intent intent, int i, int i2) {
        return Service.START_NOT_STICKY;
    }

    //When this Class is called the code in this function will be executed
    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.context = this;
        this.overlayView = new ESPView((Context) this);
        //A little message for the user when he opens the app
        //Toast.makeText(this, Toast(), Toast.LENGTH_LONG).show();
        //Init Lib

        // When you change the lib name, change also on Android.mk file
        // Both must have same name
        System.loadLibrary("bapanff");
        initFloating();
        initAlertDiag();
        startAnimation();
        DrawCanvas();

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                Thread();
                handler.postDelayed(this, 1000);
            }
        });
    }

    private void DrawCanvas() {
		/*
		 private void DrawCanvas() {
		 final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
		 WindowManager.LayoutParams.MATCH_PARENT,
		 WindowManager.LayoutParams.MATCH_PARENT,
		 getLayoutType(),
		 WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
		 WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_SECURE,
		 PixelFormat.TRANSLUCENT);
		 params.gravity = Gravity.TOP | Gravity.START;
		 params.x = 0;
		 params.y = 100;

		 windowManager.addView(overlayView, params);
		 */


        WindowManager.LayoutParams layoutParams;
        this.espParams = layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                this.getLayoutType(),
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                PixelFormat.TRANSLUCENT);
        layoutParams.gravity = Gravity.TOP | Gravity.START;
        this.espParams.x = 0;
        this.espParams.y = 100;
        this.mWindowManager.addView((View) this.overlayView, (ViewGroup.LayoutParams) this.espParams);
    }


    private void initFloating() {
        FrameLayout frameLayout = new FrameLayout(getBaseContext());
        RelativeLayout relativeLayout = new RelativeLayout(getBaseContext());
        mCollapsed = new RelativeLayout(getBaseContext()); // Markup of the icon (when the menu is minimized)
        mExpanded = new LinearLayout(getBaseContext()); // Menu markup (when the menu is expanded)
        patches = new LinearLayout(getBaseContext());
        Btns = new LinearLayout(getBaseContext());
        Btns2 = new LinearLayout(getBaseContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        mCollapsed.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        mCollapsed.setVisibility(View.VISIBLE);
        ImageView imageView = new ImageView(getBaseContext());
        startimage = imageView;
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        view1 = new LinearLayout(getBaseContext());

        mButtonPanel = new LinearLayout(getBaseContext()); // Layout of option buttons (when the menu is expanded)

        //********* Inicializar Mod **********

        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        // mRootContainer.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        mCollapsed.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        mCollapsed.setVisibility(View.VISIBLE);

        //********** Mod menu image **********
        startimage = new ImageView(getBaseContext());
        startimage.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        int applyDimension = (int) TypedValue.applyDimension(1, (float) IconSize(), getResources().getDisplayMetrics());
        startimage.getLayoutParams().height = applyDimension;
        startimage.getLayoutParams().width = applyDimension;
        startimage.requestLayout();
        startimage.setScaleType(ImageView.ScaleType.FIT_XY);
        byte[] decode = Base64.decode(Icon(), 0);
        startimage.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        ((ViewGroup.MarginLayoutParams) startimage.getLayoutParams()).topMargin = convertDipToPixels(10);

        //*********** START IMAGE **********
        startimage2 = new ImageView(getBaseContext());
        startimage2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        startimage2.getLayoutParams().height = 150;
        startimage2.getLayoutParams().width = 150;
        startimage2.requestLayout();
        startimage2.setScaleType(ImageView.ScaleType.FIT_XY);
        byte[] decode2 = Base64.decode(Icon(), 0);
        startimage2.setImageBitmap(BitmapFactory.decodeByteArray(decode2, 0, decode2.length));
        startimage2.setImageAlpha(200);
        startimage2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mCollapsed.setVisibility(View.VISIBLE);
                mCollapsed.setAlpha(ICON_ALPHA);
                mExpanded.setVisibility(View.GONE);
            }
        });
        //********** Mod menu box **********
        mExpanded.setVisibility(View.GONE);
        mExpanded.setBackgroundColor(Color.BLACK);
        mExpanded.setGravity(17);
        mExpanded.setOrientation(LinearLayout.VERTICAL);
        mExpanded.getBackground().setAlpha((180));
        mExpanded.setPadding(5, 0, 5, 0);
		/* if (dpi() > 400)
		 mExpanded.setLayoutParams(new LinearLayout.LayoutParams(550, -2)); //-1
		 if (dpi() > 350)
		 mExpanded.setLayoutParams(new LinearLayout.LayoutParams(500, -2)); //-1
		 else*/
        mExpanded.setLayoutParams(new LinearLayout.LayoutParams(550, -2)); //-1

        ScrollView scrollView = new ScrollView(getBaseContext());
		/*   if (dpi() > 400)
		 scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, 450));
		 else*/
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, 450));

        //********** Feature list **********
        patches.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        patches.setPadding(5, 5, 5, 5);
        patches.setOrientation(LinearLayout.VERTICAL);

        //********* Linear Button2 **********

        this.Btns2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.Btns2.setBackgroundColor(0);
        this.Btns2.setGravity(5);
        this.Btns2.setPadding(0, 0, 5, 0);
        this.Btns2.setOrientation(LinearLayout.HORIZONTAL);


        //********* Linear ButtonClose **********

        this.Btns.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.Btns.setBackgroundColor(0);
        this.Btns.setGravity(6);
        this.Btns.setPadding(0, 0, 5, 0);
        this.Btns.setOrientation(LinearLayout.HORIZONTAL);


        //********** Title text **********
        TextView TeamName = new TextView(this);
        TeamName.setText("Mod Menu PSTeam");
        TeamName.setTextColor(Color.parseColor("#00b8e6"));
        TeamName.setTextSize(18);
        TeamName.setTypeface(Typeface.DEFAULT_BOLD);
        //textView.setLayoutParams(layoutParams2);

        //********** Close button **********
        close = new Button(this);
        close.setBackgroundColor(Color.parseColor("#00b8e6"));
        close.setText("CLOSE");
        close.setTextSize(11.0f);
        close.setAllCaps(false);
        close.setPadding(3, 3, 3, 3);
        close.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, dp(40));
        layoutParams.topMargin = 9;
        layoutParams.bottomMargin = 1;
        close.setLayoutParams(layoutParams);

        //********* Linear Ps2 **********

        LinearLayout PSLayoutTop = new LinearLayout(this);
        PSLayoutTop.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        PSLayoutTop.setOrientation(LinearLayout.VERTICAL);

        //********* Linear Ps **********

        LinearLayout PSLayout = new LinearLayout(this);
        PSLayout.setGravity(Gravity.CENTER);
        PSLayout.setLayoutParams(new LinearLayout.LayoutParams(layoutParams.FILL_PARENT, -1));

        //********** FREE FIRE *********

        TextView nomeJogoVersao = new TextView(this);
        nomeJogoVersao.setText("Free Fire v1.57.X            ");
        nomeJogoVersao.setTextColor(Color.WHITE);
        nomeJogoVersao.setTextSize(18);
        nomeJogoVersao.setHeight(100);
        nomeJogoVersao.setGravity(Gravity.CENTER);
        nomeJogoVersao.setTypeface(Typeface.DEFAULT_BOLD);
        //nomeJogoVersao.setLayoutParams(layoutParams2);

        //********** Add views **********
        new LinearLayout.LayoutParams(-1, dp(25)).topMargin = dp(2);
        frameLayout.addView(relativeLayout);
        relativeLayout.addView(this.mCollapsed);
        relativeLayout.addView(this.mExpanded);
        mExpanded.addView(PSLayoutTop);
        PSLayoutTop.addView(startimage2);
        PSLayoutTop.addView(PSLayout);
        mCollapsed.addView(startimage);
        PSLayout.addView(TeamName);
        mExpanded.addView(scrollView);
        scrollView.addView(patches);
        this.mExpanded.addView(this.Btns2);
        this.Btns2.addView(nomeJogoVersao);
        this.mExpanded.addView(this.Btns);
        this.Btns.addView(this.close);

        this.mFloatingView = frameLayout;
        if (Build.VERSION.SDK_INT >= 26) {
            params = new WindowManager.LayoutParams(-2, -2, 2038, 8, -3);
        } else {
            params = new WindowManager.LayoutParams(-2, -2, 2002, 8, -3);
        }
        params.gravity = 8388659;
        params.x = 0;
        params.y = 100;
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);
        RelativeLayout relativeLayout2 = mCollapsed;
        LinearLayout linearLayout = mExpanded;
        frameLayout.setOnTouchListener(onTouchListener());
        startimage.setOnTouchListener(onTouchListener());
        initMenuButton(relativeLayout2, linearLayout);
        CreateMenuList();
    }

    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {
            final View collapsedView = mCollapsed;
            final View expandedView = mExpanded;
            private float initialTouchX;
            private float initialTouchY;
            private int initialX;
            private int initialY;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = motionEvent.getRawX();
                        initialTouchY = motionEvent.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int rawX = (int) (motionEvent.getRawX() - initialTouchX);
                        int rawY = (int) (motionEvent.getRawY() - initialTouchY);
                        if (rawX < 10 && rawY < 10 && isViewCollapsed()) {
                            collapsedView.setVisibility(View.GONE);
                            expandedView.setVisibility(View.VISIBLE);

                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX + ((int) (motionEvent.getRawX() - initialTouchX));
                        params.y = initialY + ((int) (motionEvent.getRawY() - initialTouchY));

                        mWindowManager.updateViewLayout(mFloatingView, params);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private boolean hide = false;

    private void initMenuButton(final View view2, final View view3) {
        startimage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view2.setVisibility(View.GONE);
                view3.setVisibility(View.VISIBLE);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (hide) {
                    view2.setVisibility(View.VISIBLE);
                    view2.setAlpha(0);
                    view3.setVisibility(View.GONE);
                    Toast.makeText(view.getContext(), "Icon hidden. Remember the hidden icon position", Toast.LENGTH_LONG).show();
                } else {
                    view2.setVisibility(View.VISIBLE);
                    view2.setAlpha(0.95f);
                    view3.setVisibility(View.GONE);
                }

            }
        });
    }

    public final void CreateMenuList() {
        String[] listFT = getFeatureList();
        for (int i = 0; i < listFT.length; i++) {
            final int feature = i;
            String str = listFT[i];
            if (str.contains("Toggle_")) {

                addSwitch(str.replace("Toggle_", ""), new InterfaceBool() {
                    public void OnWrite(boolean z) {
                        Changes(feature, 0);
                    }
                });
            } else if (str.contains("SeekBar_")) {
                String[] split = str.split("_");
                addSeekBar(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), new InterfaceInt() {
                    public void OnWrite(int i) {
                        Changes(feature, i);
                        Toast.makeText(getBaseContext(), "ACTIVATED", Toast.LENGTH_LONG).show();
                    }
                });
            } else if (str.contains("SeekBarSpot_")) {
                String[] split = str.split("_");
                addSeekBarSpot(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), new InterfaceInt() {
                    public void OnWrite(int i) {
                        Changes(feature, i);
                        Toast.makeText(getBaseContext(), "ACTIVATED", Toast.LENGTH_LONG).show();
                    }
                });
            } else if (str.contains("Category_")) {
                addCategory(str.replace("Category_", ""));
            } else if (str.contains("Button_")) {
                addButton(str.replace("Button_", ""), new InterfaceBtn() {
                    public void OnWrite() {
                        Changes(feature, 0);
                    }
                });
            } else if (str.contains("Spinner_")) {
                addSpinner(str.replace("Spinner_", ""), new InterfaceInt() {
                    @Override
                    public void OnWrite(int i) {
                        Changes(feature, i);
                    }
                });
            } else if (str.contains("InputValue_")) {
                addTextField(str.replace("InputValue_", ""), feature, new InterfaceInt() {
                    @Override
                    public void OnWrite(int i) {
                        Changes(feature, i);
                    }
                });
            } else if (str.contains("ButtonHide_")) {
                addButton(str.replace("ButtonHide_", ""), new InterfaceBtn() {
                    public void OnWrite() {
                        hide = !hide;
                    }
                });
            } else if (str.contains("RichTextView_")) {
                addRichTextView((str.replace("RichTextView_", "")));

            }


        }
    }

    private TextView textView2;
    private String featureNameExt;
    private int featureNum;
    private EditTextValue txtValue;

    public class EditTextValue {
        private int val;

        public void setValue(int i) {
            val = i;
        }

        public int getValue() {
            return val;
        }
    }

    private void addTextField(final String featureName, final int feature, final InterfaceInt interInt) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        relativeLayout2.setPadding(10, 5, 10, 5);
        relativeLayout2.setVerticalGravity(16);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = 10;

        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='roboto'>" + featureName + ": <font color='#fdd835'>Not set</font></font>"));
        textView.setTextColor(Color.parseColor("#DEEDF6"));
        textView.setLayoutParams(layoutParams);

        final TextView textViewRem = new TextView(this);
        textViewRem.setText("");

        final EditTextValue edittextval = new EditTextValue();

        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        Button button2 = new Button(this);
        button2.setLayoutParams(layoutParams2);
        button2.setBackgroundColor(Color.parseColor("#1C262D"));
        button2.setText("SET");
        button2.setTextColor(Color.parseColor("#D5E3EB"));
        button2.setGravity(17);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.show();
                textView2 = textView;
                featureNum = feature;
                featureNameExt = featureName;
                txtValue = edittextval;

                edittextvalue.setText(String.valueOf(edittextval.getValue()));
            }
        });

        relativeLayout2.addView(textView);
        relativeLayout2.addView(button2);
        patches.addView(relativeLayout2);
    }

    private void initAlertDiag() {
        LinearLayout linearLayout1 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout1.setPadding(10, 5, 0, 5);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.setGravity(17);
        linearLayout1.setLayoutParams(layoutParams);
        linearLayout1.setBackgroundColor(Color.parseColor("#171E24"));

        int i = Build.VERSION.SDK_INT >= 26 ? 2038 : 2002;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(Color.parseColor("#14171f"));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);

        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='roboto'>Tap OK to apply changes. Tap outside to cancel</font>"));
        textView.setTextColor(Color.parseColor("#DEEDF6"));
        textView.setLayoutParams(layoutParams);

        edittextvalue = new EditText(this);
        edittextvalue.setLayoutParams(layoutParams);
        edittextvalue.setMaxLines(1);
        edittextvalue.setWidth(convertDipToPixels(300));
        edittextvalue.setTextColor(Color.parseColor("#93a6ae"));
        edittextvalue.setTextSize(13.0f);
        edittextvalue.setHintTextColor(Color.parseColor("#434d52"));
        edittextvalue.setInputType(InputType.TYPE_CLASS_NUMBER);
        edittextvalue.setKeyListener(DigitsKeyListener.getInstance("0123456789-"));

        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(10);
        edittextvalue.setFilters(FilterArray);

        Button button = new Button(this);
        button.setBackgroundColor(Color.parseColor("#1C262D"));
        button.setTextColor(Color.parseColor("#D5E3EB"));
        button.setText("OK");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Changes(featureNum, Integer.parseInt(edittextvalue.getText().toString()));
                txtValue.setValue(Integer.parseInt(edittextvalue.getText().toString()));
                textView2.setText(Html.fromHtml("<font face='roboto'>" + featureNameExt + ": <font color='#41c300'>" + edittextvalue.getText().toString() + "</font></font>"));
                alert.dismiss();

                //interStr.OnWrite(editText.getText().toString());
            }
        });

        alert = new AlertDialog.Builder(this, 2).create();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(alert.getWindow()).setType(i);
        }
        linearLayout1.addView(textView);
        linearLayout1.addView(edittextvalue);
        linearLayout1.addView(button);
        alert.setView(linearLayout1);
    }

    private void addSpinner(String feature, final InterfaceInt interInt) {
        List<String> list = new LinkedList<>(Arrays.asList(feature.split("_")));

        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 10, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor("#171E24"));

        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='roboto'>" + list.get(0) + ": <font color='#41c300'></font>"));
        textView.setTextColor(Color.parseColor("#DEEDF6"));

        // Create another LinearLayout as a workaround to use it as a background
        // and to keep the 'down' arrow symbol
        // If spinner had the setBackgroundColor set, there would be no arrow symbol
        LinearLayout linearLayout2 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.setMargins(10, 2, 10, 5);
        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        linearLayout2.setGravity(17);
        linearLayout2.setBackgroundColor(Color.parseColor("#1C262D"));
        linearLayout2.setLayoutParams(layoutParams2);

        Spinner spinner = new Spinner(this);
        spinner.setPadding(5, 10, 5, 8);
        spinner.setLayoutParams(layoutParams2);
        spinner.getBackground().setColorFilter(1, PorterDuff.Mode.SRC_ATOP); //trick to show white down arrow color
        //Creating the ArrayAdapter instance having the list
        list.remove(0);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                ((TextView) parentView.getChildAt(0)).setTextColor(Color.parseColor("#f5f5f5"));
                interInt.OnWrite(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        linearLayout.addView(textView);
        linearLayout2.addView(spinner);
        patches.addView(linearLayout);
        patches.addView(linearLayout2);
    }

    private void addCategory(String text) {
        TextView textView = new TextView(this);
        textView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        textView.setText(text);
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setTextColor(Color.parseColor("#FF0000"));
        textView.setTypeface(null, Typeface.BOLD);
        textView.setPadding(10, 5, 0, 5);
        patches.addView(textView);
    }

    private void addRichTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(Html.fromHtml(text));
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setPadding(10, 5, 10, 5);
        patches.addView(textView);
    }

    public void addButton(String feature, final InterfaceBtn interfaceBtn) {
        final GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        String str2 = "#00b8e6";
        gradientDrawable.setColor(Color.parseColor(str2));
        gradientDrawable.setStroke(8, Color.parseColor(str2));
        gradientDrawable.setCornerRadius(10.0f);
        final GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable2.setColor(0);
        gradientDrawable2.setStroke(8, Color.parseColor(str2));
        gradientDrawable2.setCornerRadius(10.0f);

        final Button button = new Button(this);
        //To fix CPP error: https://stackoverflow.com/questions/23048567/android-signal-11-rs-cpp-error-blur-radius-out-of-0-25-pixel-bound
        button.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(7, 5, 7, 5);
        button.setText(feature + " [OFF]");
        button.setTextColor(Color.WHITE);
        button.setTextSize(11.0f);
        button.setAllCaps(false);
        button.setBackground(gradientDrawable2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, dp(40));
        button.setPadding(3, 3, 3, 3);
        layoutParams2.bottomMargin = 5;
        button.setLayoutParams(layoutParams2);
        final String feature2 = feature;
        button.setOnClickListener(new View.OnClickListener() {
            private boolean isActive = true;

            public void onClick(View v) {
                interfaceBtn.OnWrite();
                if (isActive) {

                    button.setText(feature2 + " [ON]");
                    button.setBackground(gradientDrawable);
                    isActive = false;
                    return;
                }

                button.setText(feature2 + " [OFF]");
                button.setBackground(gradientDrawable2);
                isActive = true;
            }
        });
        patches.addView(button);
    }

    private void addSwitch(String str, final InterfaceBool sw) {
        final Switch switchR = new Switch(this);
        //To fix CPP error: https://stackoverflow.com/questions/23048567/android-signal-11-rs-cpp-error-blur-radius-out-of-0-25-pixel-bound
        switchR.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        switchR.setBackgroundColor(Color.parseColor("#000000"));
        switchR.getBackground().setAlpha(1);
        switchR.setText(Html.fromHtml("<font face='monospace'><b>" + str + "</b></font>"));
        switchR.getTrackDrawable().setColorFilter(Color.parseColor("WHITE"), PorterDuff.Mode.SRC_IN);
        switchR.getThumbDrawable().setColorFilter(Color.parseColor("WHITE"), PorterDuff.Mode.SRC_IN);
        switchR.setShadowLayer(12.0f, 0.0f, 0.0f, Color.parseColor("BLUE"));
        switchR.setTextColor(-1);
        switchR.setTypeface((Typeface) null, Typeface.BOLD);
        switchR.setTextSize(17);
        switchR.setPadding(10, 15, 0, 15);
        switchR.setShadowLayer(30.0f, 0f, 0f, Color.parseColor("BLUE"));
        switchR.setTextColor(Color.parseColor("#FFFFFF"));

        switchR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    switchR.setBackgroundColor(Color.parseColor("#000000"));
                    switchR.getBackground().setAlpha(1);
                    switchR.getTrackDrawable().setColorFilter(Color.parseColor("BLACK"), PorterDuff.Mode.SRC_IN);
                    switchR.getThumbDrawable().setColorFilter(Color.parseColor("RED"), PorterDuff.Mode.SRC_IN);
                    switchR.setShadowLayer(100.0f, 0.0f, 0.0f, Color.parseColor("#0000FF"));
                    switchR.setShadowLayer(50.0f, 0.0f, 0.0f, Color.parseColor("#FF0000"));
                    switchR.setTextColor(Color.parseColor("#FFFFFF"));

                } else {
                    switchR.setBackgroundColor(Color.parseColor("#000000"));
                    switchR.getBackground().setAlpha(1);
                    switchR.getTrackDrawable().setColorFilter(Color.parseColor("WHITE"), PorterDuff.Mode.SRC_IN);
                    switchR.getThumbDrawable().setColorFilter(Color.parseColor("WHITE"), PorterDuff.Mode.SRC_IN);
                    switchR.setShadowLayer(12.0f, 0.0f, 0.0f, Color.parseColor("#0000FF"));
                    switchR.setShadowLayer(30.0f, 0.0f, 0.0f, Color.parseColor("BLUE"));
                    switchR.setTextColor(Color.parseColor("#FFFFFF"));
                }
                sw.OnWrite(z);
            }
        });
        patches.addView(switchR);
    }


    private void addSeekBar(final String feature, final int prog, int max, final InterfaceInt interInt) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 0, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(Color.parseColor("#000000"));
        linearLayout.getBackground().setAlpha(1);
        linearLayout.setLayoutParams(layoutParams);
        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + ": <font color='#00b8e6'>" + "DEACTIVATED" + "</font>"));
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        SeekBar seekBar = new SeekBar(this);
        seekBar.setPadding(25, 10, 35, 10);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        seekBar.setMax(max);
        seekBar.setProgress(prog);
        seekBar.getProgressDrawable().setColorFilter(Color.parseColor("WHITE"), PorterDuff.Mode.MULTIPLY);
        seekBar.getThumb().setColorFilter(Color.parseColor("#00b8e6"), PorterDuff.Mode.SRC_IN);
        final TextView textView2 = textView;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            int l;

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {


                if (i == 0) {
                    seekBar.setProgress(i);
                    interInt.OnWrite(i);
                    TextView textView = textView2;
                    textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + ": <font color='#00b8e6'>" + "DEACTIVATED" + "</font>"));
                    return;
                }
                interInt.OnWrite(i);
                textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + ": <font color='#00b8e6'>" + i + "</font>"));
            }
        });

        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        patches.addView(linearLayout);
    }

    private void addSeekBarSpot(final String feature, final int prog, int max, final InterfaceInt interInt) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 0, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(Color.parseColor("#000000"));
        linearLayout.getBackground().setAlpha(1);
        linearLayout.setLayoutParams(layoutParams);

        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + ": <font color='#00b8e6'>" + "DEACTIVATED" + "</font>"));
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        SeekBar seekBar = new SeekBar(this);
        seekBar.setPadding(25, 10, 35, 10);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        seekBar.setMax(max);
        seekBar.setProgress(prog);
        seekBar.getProgressDrawable().setColorFilter(Color.parseColor("WHITE"), PorterDuff.Mode.MULTIPLY);
        seekBar.getThumb().setColorFilter(Color.parseColor("#00b8e6"), PorterDuff.Mode.SRC_IN);

        final TextView textView2 = textView;
        final SeekBar seekBar2 = seekBar;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar2) {
            }

            public void onStopTrackingTouch(SeekBar seekBar2) {
            }

            int l;

            public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
                if (i == 0) {
                    seekBar2.setProgress(i);
                    interInt.OnWrite(i);
                    TextView textView = textView2;
                    textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + ": <font color='#00b8e6'>" + "DEACTIVATED" + "</b></font>"));
                } else if (i == 1) {
                    seekBar2.setProgress(i);
                    interInt.OnWrite(i);
                    TextView textView = textView2;
                    textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + ": <font color='#00b8e6'>" + "HEAD" + "</b></font>"));
                } else if (i == 2) {
                    seekBar2.setProgress(i);
                    interInt.OnWrite(i);
                    TextView textView = textView2;
                    textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + ": <font color='#00b8e6'>" + "BODY" + "</b></font>"));
                } else if (i == 3) {
                    seekBar2.setProgress(i);
                    interInt.OnWrite(i);
                    TextView textView = textView2;
                    textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + ": <font color='#00b8e6'>" + "FOOT" + "</b></font>"));
                }
                interInt.OnWrite(i);
            }
        });

        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        patches.addView(linearLayout);
    }


    public boolean isViewCollapsed() {
        return mFloatingView == null || mCollapsed.getVisibility() == View.VISIBLE;
    }

    //For our image a little converter
    private int convertDipToPixels(int i) {
        return (int) ((((float) i) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int dp(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    //Destroy our View
    public void onDestroy() {
        super.onDestroy();
        View view = mFloatingView;
        if (view != null) {
            mWindowManager.removeView(view);
        }
        ESPView espView = this.overlayView;
        if (espView != null) {
            this.mWindowManager.removeView(espView);
            this.overlayView = null;
        }
    }

    //View animation
    public void startAnimation() {
        final int start = Color.parseColor("#000000");
        final int end = Color.parseColor("#FF0000");

        final ArgbEvaluator evaluator = new ArgbEvaluator();
        gdAnimation.setCornerRadius(MENU_CORNER);
        gdAnimation.setOrientation(GradientDrawable.Orientation.TL_BR);
        final GradientDrawable gradient = gdAnimation;

        ValueAnimator animator = TimeAnimator.ofFloat(100.0f, 100.0f);
        animator.setDuration(5000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float fraction = valueAnimator.getAnimatedFraction();
                int newStrat = (int) evaluator.evaluate(fraction, start, end);
                int newEnd = (int) evaluator.evaluate(fraction, end, start);
                int[] newArray = {newStrat, newEnd};
                gradient.setColors(newArray);
            }
        });

        animator.start();
    }

    //Check if we are still in the game. If now our Menu and Menu button will dissapear
    private boolean isNotInGame() {
        RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo.importance != 100;
    }

    //Same as above so it wont crash in the background and therefore use alot of Battery life
    public void onTaskRemoved(Intent intent) {
        stopSelf();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onTaskRemoved(intent);
    }

    /* access modifiers changed from: private */
    public void Thread() {
        if (mFloatingView == null) {
            return;
        }
        if (isNotInGame()) {
            mFloatingView.setVisibility(View.INVISIBLE);
        } else {
            mFloatingView.setVisibility(View.VISIBLE);
        }
    }


    private interface InterfaceBtn {
        void OnWrite();
    }

    private interface InterfaceInt {
        void OnWrite(int i);
    }

    private interface InterfaceBool {
        void OnWrite(boolean z);
    }

    private interface InterfaceStr {
        void OnWrite(String s);
    }
}
