package com.example.paramedix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    
    lateinit var loginFragmentAdapter:LoginFragmentAdapter;
    private lateinit var viewPager: ViewPager2;
    private lateinit var tabLayout: TabLayout;
    private var page:Int=2
    val headText= arrayOf("Medical Worker","Beneficiary")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_main)

        tabLayout=findViewById(R.id.tabsLayout)
        loginFragmentAdapter= LoginFragmentAdapter(supportFragmentManager,lifecycle)

        viewPager=findViewById(R.id.container)
        viewPager.setCurrentItem(page)
        viewPager.adapter=loginFragmentAdapter

        TabLayoutMediator(tabLayout,viewPager){tab,position->
            tab.text="Login as "+headText[position]
        }.attach()
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

        })
    }
}