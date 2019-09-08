package com.digidig.ccp.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.android.synthetic.main.activity_example.view.*
import kotlinx.android.synthetic.main.fragment_introduction.*
import kotlinx.android.synthetic.main.fragment_introduction.view.*

class IntroductionFragment : Fragment() {

    private lateinit var vv: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vv = inflater.inflate(R.layout.fragment_introduction, container, false)
        return vv
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        vv.button_letsGo.setOnClickListener { (activity as ExampleActivity).viewPager.currentItem = 1 }
    }
}
