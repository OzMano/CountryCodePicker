package com.digidig.ccp.sample

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView

import com.digidig.lib.ccp.CountryCodePicker
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.android.synthetic.main.activity_example.view.*
import kotlinx.android.synthetic.main.fragment_custom_color.*

class CustomColorFragment : Fragment() {
    
    private lateinit var vv: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vv = inflater.inflate(R.layout.fragment_custom_color, container, false)
        return vv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        relative_color1!!.setOnClickListener {
            setColor(
                1,
                activity!!.resources.getColor(R.color.color1)
            )
        }

        relative_color2!!.setOnClickListener {
            setColor(
                2,
                activity!!.resources.getColor(R.color.color2)
            )
        }

        relative_color3!!.setOnClickListener {
            setColor(
                3,
                activity!!.resources.getColor(R.color.color3)
            )
        }

        button_next!!.setOnClickListener {
            (activity as ExampleActivity).viewPager.currentItem =
                (activity as ExampleActivity).viewPager.currentItem + 1
        }
    }

    private fun setColor(selection: Int, color: Int) {
        ccp!!.textColor = color
        //textView
        textView_title!!.setTextColor(color)

        //editText
        editText_phone!!.setTextColor(color)
        editText_phone!!.setHintTextColor(color)
        editText_phone!!.background.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)

        //remove selected bg
        resetBG()

        //set selected bg
        val selectedBGColor = activity!!.resources.getColor(R.color.selectedTile)
        when (selection) {
            1 -> relative_color1!!.setBackgroundColor(selectedBGColor)
            2 -> relative_color2!!.setBackgroundColor(selectedBGColor)
            3 -> relative_color3!!.setBackgroundColor(selectedBGColor)
        }
    }

    private fun resetBG() {
        relative_color1!!.setBackgroundColor(activity!!.resources.getColor(R.color.dullBG))
        relative_color2!!.setBackgroundColor(activity!!.resources.getColor(R.color.dullBG))
        relative_color3!!.setBackgroundColor(activity!!.resources.getColor(R.color.dullBG))
    }

}
