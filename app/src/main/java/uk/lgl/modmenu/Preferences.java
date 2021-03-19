package uk.lgl.modmenu;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

//TODO
//Write up android logcat on readme

public class Preferences {
    private static SharedPreferences.Editor editor;
    public static Context context;
    public static boolean isSoundEnabled = true, savePref = false, animation = true, expanded = false;

    public static void changeFeatureInt(String feature, int featureNum, int value) {
        editor.putInt(feature, value).apply();
    }

    public static void changeFeatureBoolean(String feature, int featureNum, boolean value) {
        if (featureNum == 1000)
            isSoundEnabled = value;
        if (featureNum == 1001)
            animation = value;
        if (featureNum == 1002)
            expanded = value;
        if (featureNum == 9998)
            savePref = value;
        editor.putBoolean(feature, value).apply();
    }

    //TODO: changeFeatureString

    public static int loadPrefInt(String featureName, int featureNum) {
        if (savePref) {
            SharedPreferences preferences = context.getSharedPreferences("mod_menu", 0);
            editor = preferences.edit();
            int i = preferences.getInt(featureName, featureNum);
            return i;
        }
        return featureNum;
    }

    public static boolean loadPrefBoolean(String featureName, int featureNum) {
        SharedPreferences preferences = context.getSharedPreferences("mod_menu", 0);
        if (featureNum >= 9998) {
            savePref = preferences.getBoolean(featureName, false);
        }
        if (savePref || featureNum >= 1000) {
            editor = preferences.edit();
            if (featureNum == 1000 && !preferences.contains("Sounds"))
                return true;
            if (featureNum == 1001 && !preferences.contains("Color animation"))
                return true;
            boolean bool = preferences.getBoolean(featureName, false);
            return bool;
        }
        return false;
    }
}
