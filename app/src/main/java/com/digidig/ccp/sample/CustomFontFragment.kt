package com.digidig.ccp.sample


import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.digidig.lib.ccp.CountryCodePicker
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.android.synthetic.main.activity_example.view.*
import kotlinx.android.synthetic.main.fragment_custom_font.*

class CustomFontFragment : Fragment() {

    private lateinit var vv: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vv = inflater.inflate(R.layout.fragment_custom_font, container, false)
        return vv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyCustomFonts()
        setClickListener()
    }

    private fun applyCustomFonts() {
        //        setTTFfont(ccp2,"bookos.ttf");
        setTTFfont(ccp3!!, "hack.ttf")
        setTTFfont(ccp4!!, "playfair.ttf")
        setTTFfont(ccp5!!, "raleway.ttf")
        setTTFfont(ccp6!!, "titillium.ttf")
    }

    private fun setTTFfont(ccp: CountryCodePicker, fontFileName: String) {
        val typeFace = Typeface.createFromAsset(context!!.assets, fontFileName)
        ccp.typeFace = typeFace
    }

    private fun setClickListener() {

        button_next.setOnClickListener {
            (activity as ExampleActivity).viewPager.currentItem =
                (activity as ExampleActivity).viewPager.currentItem + 1
        }
    }
}
