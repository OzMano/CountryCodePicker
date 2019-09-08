package com.digidig.ccp.sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_example.*

class ExampleActivity : AppCompatActivity() {
    private var pagerAdapter: PagerAdapter? = null
    private var init = 0
    private var initLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        init = intent.getIntExtra(EXTRA_INIT_TAB, 0)
        setUpViewPager()
    }

    /**
     * Assign adapter to viewPager
     */
    private fun setUpViewPager() {
        if (pagerAdapter == null) {
            pagerAdapter = PagerAdapter(supportFragmentManager)
        }
        viewPager.adapter = pagerAdapter
        if (!initLoaded) {
            viewPager.currentItem = init
            initLoaded = true
        }
    }

    internal inner class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> return IntroductionFragment()
                1 -> return DefaultCountryFragment()
                2 -> return CountryPreferenceFragment()
                3 -> return CustomMasterFragment()
                4 -> return SetCountryFragment()
                5 -> return GetCountryFragment()
                6 -> return FullNumberFragment()
                7 -> return CustomColorFragment()
                8 -> return CustomSizeFragment()
                9 -> return CustomFontFragment()
                10 -> return PhoneNumberValidityFragment()
            }
            return null
        }

        override fun getCount(): Int {
            return 11
        }
    }

    companion object {

        val EXTRA_INIT_TAB = "extraInitTab"
    }
}
