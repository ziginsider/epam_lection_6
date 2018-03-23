package io.github.ziginsider.epam_lection_6;

import android.content.Context;

/**
 * Created by zigin on 23.03.2018.
 */

public class SingletonSaveContext {
    private Context context;
    private static SingletonSaveContext instance;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static SingletonSaveContext getInstance() {
        if (instance == null) {
            instance = new SingletonSaveContext();
        }
        return instance;
    }
}
