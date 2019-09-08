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
import kotlinx.android.synthetic.main.fragment_custom_master_list.*

class CustomMasterFragment : Fragment() {
    
    private lateinit var vv: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vv = inflater.inflate(R.layout.fragment_custom_master_list, container, false)
        return vv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextWatcher()
        addClickListeners()
    }

    private fun addClickListeners() {

        button_setCustomMaster.setOnClickListener {
            val customMasterCountries: String
            try {
                customMasterCountries = editText_countryPreference.text.toString()
                ccp.customMasterCountries = customMasterCountries
                Toast.makeText(
                    activity,
                    "Master list has been changed. Tap on ccp to see the changes.",
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
                button_setCustomMaster.text = "set '$s' as Custom Master List."
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }
}
