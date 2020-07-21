package com.chethan.abn

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


/**
 * Created by Chethan on 5/3/2019.
 */

@HiltAndroidApp
open class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()


    }
}
