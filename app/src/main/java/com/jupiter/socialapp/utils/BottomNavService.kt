package com.jupiter.socialapp.utils

import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jupiter.socialapp.R
import com.jupiter.socialapp.views.*

@BindingMethods(
    value = [
        BindingMethod(
            type = BottomNavigationView::class,
            attribute = "onNavigationItemSelected",
            method = "setOnNavigationItemSelectedListener"
        )]
)
class BottomNavService(var fragmentManager: FragmentManager) {
    private val profileFragment = ProfileFragment()
    private val searchFragment = SearchFragment()
    private val cartFragment = CartFragment()
    private val homeFragment = HomeFragment()
    private val likeFragment = NotificationFragment()

    init {
        setFragment(homeFragment)
    }

    fun onNavigationClick(@NonNull it: MenuItem): Boolean {
        when (it.itemId) {
            R.id.profile_nav -> setFragment(profileFragment)
            R.id.search_nav -> setFragment(searchFragment)
            R.id.home_nav -> setFragment(homeFragment)
            R.id.cart_nav -> setFragment(cartFragment)
            R.id.like_nav -> setFragment(likeFragment)
        }
        return true
    }

    private fun setFragment(fragment: Fragment) {

        fragmentManager.beginTransaction().apply { replace(R.id.base_fragment, fragment) }.commit()
    }

    companion object {
        @Volatile
        private var INSTANCE: BottomNavService? = null
        fun getInstance(newFragmentManager: FragmentManager): BottomNavService {
            if (INSTANCE == null) {
                INSTANCE = BottomNavService(newFragmentManager)
            } else {
                INSTANCE!!.fragmentManager = newFragmentManager
            }
            return INSTANCE!!
        }
    }
}