package com.ezetap.test

import android.os.Bundle
import com.ezetap.test.databinding.ActivityMainBinding
import com.ezetap.test.utils.extensions.setDataBindingView
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity()  {

    private lateinit var binding: ActivityMainBinding

    /**
     * onCreate()
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setDataBindingView(R.layout.activity_main)

    }
}
