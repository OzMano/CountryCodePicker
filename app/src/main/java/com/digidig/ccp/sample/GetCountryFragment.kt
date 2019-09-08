package com.digidig.ccp.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.digidig.lib.ccp.CountryCodePicker
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.android.synthetic.main.activity_example.view.*
import kotlinx.android.synthetic.main.fragment_get_country.view.*

class GetCountryFragment : Fragment() {
    
    private lateinit var vv: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vv = inflater.inflate(R.layout.fragment_get_country, container, false)
        return vv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        vv.button_readCountry.setOnClickListener {
            vv.get_country_country_name_tv.text = vv.ccp.selectedCountryName
            vv.get_country_country_code_tv.text = vv.ccp.selectedCountryCode
            vv.get_country_country_name_code_tv.text = vv.ccp.selectedCountryNameCode
        }

        vv.button_next.setOnClickListener {
            (activity as ExampleActivity).viewPager.currentItem =
                (activity as ExampleActivity).viewPager.currentItem + 1
        }
    }
}
