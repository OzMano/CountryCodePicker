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

import com.digidig.lib.ccp.CountryCodePicker
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.android.synthetic.main.activity_example.view.*
import kotlinx.android.synthetic.main.fragment_country_preference.*
import kotlinx.android.synthetic.main.fragment_country_preference.view.*

class CountryPreferenceFragment : Fragment() {

    private lateinit var vv: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        vv = inflater.inflate(R.layout.fragment_country_preference, container, false)
        return vv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextWatcher()
        addClickListeners()
    }

    private fun addClickListeners() {

        vv.button_setCountryPreference.setOnClickListener {
            val countryPreference: String
            try {
                countryPreference = vv.editText_countryPreference.text.toString()
                vv.ccp.setCountryPreference(countryPreference)
                Toast.makeText(
                    activity,
                    "Country preference list has been changed, " + "click on CCP to see them at top of list.",
                    Toast.LENGTH_LONG
                ).show()
            } catch (ex: Exception) {

            }
        }


        button_next.setOnClickListener {
            (activity as ExampleActivity).viewPager.currentItem =
                (activity as ExampleActivity).viewPager.currentItem + 1
        }
    }

    private fun editTextWatcher() {
        editText_countryPreference.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                button_setCountryPreference.text = "set '$s' as Country preference."
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }
}
