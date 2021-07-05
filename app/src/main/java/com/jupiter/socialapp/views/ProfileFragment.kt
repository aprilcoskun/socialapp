package com.jupiter.socialapp.views

import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.Shader.TileMode
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.tabs.TabLayout
import com.jupiter.socialapp.R
import com.jupiter.socialapp.databinding.FragmentProfileBinding
import com.jupiter.socialapp.models.User


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private var user: User = User(
        "Nisan Coskun",
        "https://i.pinimg.com/originals/7d/1a/3f/7d1a3f77eee9f34782c6f88e97a6c888.jpg",
        "5minutesful"
    )

    //    var tabLayout = binding.tabLayoutProfile
    //    var viewPager = binding.pagerProfile
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        binding.user = user
        tabLayout = binding.tabLayoutProfile
        viewPager = binding.pagerProfile

        val gradientColors = context?.let {
            intArrayOf(
                it.getColor(R.color.pastel_violet),
                it.getColor(R.color.pastel_blue),
                it.getColor(R.color.granny_smith_apple),
                it.getColor(R.color.pastel_yellow),
                it.getColor(R.color.pastel_orange),
                it.getColor(R.color.pastel_red)
            )
        }

        binding.btnFollow.measure(0, 0)
        binding.btnFollow.paint.shader = LinearGradient(
            0.0f,
            0.0f,
            binding.btnFollow.measuredWidth.toFloat(),
            0.0f,
            gradientColors!!,
            floatArrayOf(0f, 0.2f, 0.4f, 0.6f, 0.8f, 1f),
            TileMode.CLAMP
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Handle tab select
                selectPage(tab!!.id)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })
    }

    fun selectPage(pageIndex: Int) {
        tabLayout.setScrollPosition(pageIndex, 0f, true)
        viewPager.currentItem = pageIndex
    }

    companion object {
        @JvmStatic
        @BindingAdapter("profileImage")
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide.with(view.context)
                .load(imageUrl).apply(RequestOptions().circleCrop())
                .into(view)
        }
    }
}
