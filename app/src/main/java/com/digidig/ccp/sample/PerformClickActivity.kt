package com.digidig.ccp.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.digidig.lib.ccp.CountryCodePicker
import kotlinx.android.synthetic.main.activity_perform_click.*

class PerformClickActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perform_click)

        perform_click_btn.setOnClickListener { ccp.performClick() }
    }
}
