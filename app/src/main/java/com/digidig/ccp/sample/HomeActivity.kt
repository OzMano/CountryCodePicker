package com.digidig.ccp.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        assignViews()
    }

    private fun assignViews() {
        setclick(textIntro, 0)

        setclick(textDefaultCountry, 1)

        setclick(textCountryPreference, 2)

        setclick(textCustomMaster, 3)

        setclick(textSetCountry, 4)

        setclick(textGetCountry, 5)

        setclick(textFullNumber, 6)

        setclick(textCustomColor, 7)

        setclick(textCustomSize, 8)

        setclick(textCustomFont, 9)

        setclick(check_validity_tv, 10)

        buttonGo.setOnClickListener {
            val i = Intent(baseContext, ExampleActivity::class.java)
            i.putExtra(ExampleActivity.EXTRA_INIT_TAB, 0)
            startActivity(i)
        }
    }

    private fun setclick(text: TextView, tabIndex: Int) {
        text.setOnClickListener {
            val i = Intent(baseContext, ExampleActivity::class.java)
            i.putExtra(ExampleActivity.EXTRA_INIT_TAB, tabIndex)
            startActivity(i)
        }
    }
}
