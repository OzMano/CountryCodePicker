package com.digidig.ccp.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.digidig.lib.ccp.CountryCodePicker
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.android.synthetic.main.activity_example.view.*
import kotlinx.android.synthetic.main.fragment_default_country.view.*

class DefaultCountryFragment : Fragment() {
    
    private lateinit var vv: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vv = inflater.inflate(R.layout.fragment_default_country, container, false)
        return vv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextWatcher()
        addClickListeners()
    }

    private fun addClickListeners() {
        vv.button_setDefaultCode.setOnClickListener {
            try {
                val code = Integer.parseInt(vv.editText_defaultCode.text.toString())
                vv.ccp.setDefaultCountryUsingPhoneCode(code)
                Toast.makeText(
                    activity,
                    "Now default country is " + vv.ccp.defaultCountryName + " with phone code " + vv.ccp.defaultCountryCode,
                    Toast.LENGTH_LONG
                ).show()
            } catch (ex: Exception) {
                Toast.makeText(activity, "Invalid number format", Toast.LENGTH_LONG).show()
            }
        }

        vv.default_country_set_default_name_code_btn.setOnClickListener {
            val nameCode: String
            try {
                nameCode = vv.default_country_default_name_code_edt.text.toString()
                Log.d(TAG, "nameCode = $nameCode")
                vv.ccp.setDefaultCountryUsingNameCode(nameCode)
                Toast.makeText(
                    activity,
                    "Now default country is " + vv.ccp.defaultCountryName + " with phone code " + vv.ccp.defaultCountryCode,
                    Toast.LENGTH_LONG
                ).show()
            } catch (ex: Exception) {

            }
        }

        vv.button_resetToDefault.setOnClickListener { vv.ccp.resetToDefaultCountry() }

        vv.button_next.setOnClickListener {
            (activity as ExampleActivity).viewPager.currentItem =
                (activity as ExampleActivity).viewPager.currentItem + 1
        }
    }

    private fun editTextWatcher() {
        vv.editText_defaultCode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                vv.button_setDefaultCode.text = "set $s as Default Country Code"
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        vv.default_country_default_name_code_edt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                vv.default_country_set_default_name_code_btn.text = "set '$s' as Default Country Name Code"
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }

    companion object {

        val TAG = DefaultCountryFragment::class.java.simpleName
    }
}
