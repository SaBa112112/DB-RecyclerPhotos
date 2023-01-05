package com.example.dbrecyclerphotos.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dbrecyclerphotos.fragments.Fragment_1
import com.example.dbrecyclerphotos.fragments.Fragment_2

class ViewPagerFragmentAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        if (position == 0){
            return Fragment_1()
        }
        else if(position == 1){
            return Fragment_2()
        }
        return Fragment()
    }
}
