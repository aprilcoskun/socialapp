package com.jupiter.socialapp.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jupiter.socialapp.R
import com.jupiter.socialapp.databinding.FragmentLikeBinding

class LikeFragment : Fragment() {
    private lateinit var binding: FragmentLikeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_like, container, false)
        return binding.root
    }
}