package com.digidig.ccp.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.digidig.lib.ccp.Country
import com.digidig.lib.ccp.CountryCodePicker
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.android.synthetic.main.activity_example.view.*
import kotlinx.android.synthetic.main.fragment_set_country.view.*

class SetCountryFragment : Fragment() {
    
    private lateinit var vv: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vv = inflater.inflate(R.layout.fragment_set_country, container, false)
        return vv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextWatcher()
        addClickListeners()
    }

    private fun addClickListeners() {
        vv.button_setCountry.setOnClickListener {
            var code = -1
            try {
                code = Integer.parseInt(vv.editText_countryCode.text.toString())
                vv.ccp.setCountryForPhoneCode(code)
            } catch (ex: Exception) {
                Toast.makeText(activity, "Invalid number format", Toast.LENGTH_LONG).show()
            }
        }

        vv.button_setCountryNameCode.setOnClickListener {
            try {
                val code = vv.editText_countryNameCode.text.toString()
                vv.ccp.setCountryForNameCode(code)
            } catch (ex: Exception) {
            }
        }

        vv.button_next.setOnClickListener {
            (activity as ExampleActivity).viewPager.currentItem =
                (activity as ExampleActivity).viewPager.currentItem + 1
        }
    }

    private fun editTextWatcher() {
        vv.editText_countryCode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                vv.button_setCountry.text = "Set country with code $s"
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        vv.editText_countryNameCode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                vv.button_setCountryNameCode.text = "Set country with name code '$s'"
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        vv.ccp.setOnCountryChangeListener { selectedCountry ->
            Toast.makeText(
                context, "This is from OnCountryChangeListener. " +
                        "\n Country updated to " + selectedCountry.name
                        + "(" + vv.ccp.selectedCountryCodeWithPlus + ")", Toast.LENGTH_SHORT
            ).show()
        }
    }
}
