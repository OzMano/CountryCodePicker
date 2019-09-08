package com.digidig.ccp.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.AppCompatEditText
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.digidig.lib.ccp.CountryCodePicker
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.android.synthetic.main.activity_example.view.*
import kotlinx.android.synthetic.main.fragment_full_number.view.*

class FullNumberFragment : Fragment() {
    
    private lateinit var vv: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vv = inflater.inflate(R.layout.fragment_full_number, container, false)
        return vv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerCarrierEditText()
        setClickListener()
        addTextWatcher()
    }

    private fun addTextWatcher() {
        vv.editText_loadFullNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                vv.button_loadFullNumber.text = "Load $s to CCP."
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
    }

    private fun setClickListener() {
        vv.button_loadFullNumber.setOnClickListener {
            vv.ccp_loadFullNumber.fullNumber = vv.editText_loadFullNumber.text!!.toString()
        }

        vv.button_getFullNumberWithPlus.setOnClickListener { vv.editText_getFullNumber.setText(vv.ccp_getFullNumber.fullNumber) }

        vv.button_next.setOnClickListener {
            (activity as ExampleActivity).viewPager.currentItem = (activity as ExampleActivity).viewPager.currentItem + 1
        }
    }

    private fun registerCarrierEditText() {
        vv.ccp_loadFullNumber.registerPhoneNumberTextView(vv.editText_loadCarrierNumber)
        vv.ccp_loadFullNumber.setPhoneNumberInputValidityListener { ccp, isValid ->
            Log.d(
                TAG,
                ccp.phoneNumber.toString() + " " + if (isValid) "is valid" else "not valid"
            )
        }

        val mPhoneUtil = PhoneNumberUtil.createInstance(context!!)
        vv.ccp_getFullNumber.registerPhoneNumberTextView(vv.editText_getCarrierNumber)
        vv.ccp_getFullNumber.setPhoneNumberInputValidityListener { ccp, isValid ->
            Log.d(TAG, ccp.phoneNumber.toString() + " " + if (isValid) "is valid" else "not valid")
            Log.d(
                TAG, "PhoneNumberFormat.E164 = " + mPhoneUtil.format(
                    ccp.phoneNumber!!,
                    PhoneNumberUtil.PhoneNumberFormat.E164
                )
            )
        }
    }

    companion object {

        val TAG = FullNumberFragment::class.java.simpleName
    }
}
