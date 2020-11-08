package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.R
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.fragments.CatFactFragment

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CatFactFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }

    }



}