package com.example.paramedix

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class LoginFragmentAdapter(fm: FragmentManager,lifecycle:Lifecycle): FragmentStateAdapter(fm,lifecycle) {

    companion object{
        private val num_items:Int=2
    }


    override fun getItemCount(): Int {
        return num_items
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return LoginFragment.newInstance("Medical Worker")
        }
        return LoginFragment.newInstance("Beneficiary")
    }
}