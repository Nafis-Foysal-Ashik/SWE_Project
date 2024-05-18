package com.example.study;

import android.content.Context;
import android.content.Intent;

public class ActivityFactory {

    public Intent createActivity(Context context, Class<?> cls) {
        return new Intent(context, cls);
    }
}
