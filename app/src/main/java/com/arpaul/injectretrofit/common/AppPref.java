package com.arpaul.injectretrofit.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppPref {
    private SharedPreferences preferences;
    private SharedPreferences.Editor edit;

    public AppPref(Context context) {
        preferences		=	PreferenceManager.getDefaultSharedPreferences(context);
//        preferences		=	context.getSharedPreferences(context.getString(R.string.app_name), MODE_PRIVATE);
        edit			=	preferences.edit();
    }

    public void setDataPref(String strKey, String strValue) {
        edit.putString(strKey, strValue);
        commitPreference();
    }

    public void removePref(String strKey)
    {
        edit.remove(strKey);
    }

    public void commitPreference()
    {
        edit.commit();
    }

    public String getDataPref(String strKey, String defaultValue ) {
        return preferences.getString(strKey, defaultValue);
    }

    public void clearPref() {
        edit.clear();
        commitPreference();
    }
}
