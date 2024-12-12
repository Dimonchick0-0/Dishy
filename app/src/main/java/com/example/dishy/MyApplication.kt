package com.example.dishy

import android.app.Application
import com.example.dishy.di.app.DaggerApplicationComponent

class MyApplication: Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}