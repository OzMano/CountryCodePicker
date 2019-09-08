package com.digidig.ccp.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.digidig.lib.ccp.CountryCodePicker
import kotlinx.android.synthetic.main.fragment_phone_number_validity.view.*

class PhoneNumberValidityFragment : Fragment() {

    private lateinit var vv: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vv = inflater.inflate(R.layout.fragment_phone_number_validity, container, false)
        return vv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        vv.button_next.setOnClickListener { activity!!.finish() }

        vv.check_btn.setOnClickListener {
            if (vv.ccp.isValid) {
                Toast.makeText(
                    context,
                    "number " + vv.ccp.fullNumber + " is valid.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    context,
                    "number " + vv.ccp.fullNumber + " not valid!!!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
