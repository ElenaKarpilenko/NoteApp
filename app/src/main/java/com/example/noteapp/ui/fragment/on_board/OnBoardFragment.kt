package com.example.noteapp.ui.fragment.on_board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.ui.adapter.OnBoardAdapter
import com.example.noteapp.utils.SharedPreference

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        btnGetStarted()
        openHome()
    }
    private fun initialize() {
        binding.viewPager2.adapter = OnBoardAdapter(this@OnBoardFragment)
        SharedPreference.unit(requireContext())
    }


    private fun setupListener() = with(binding.viewPager2) {
        binding.tvSend.setOnClickListener {
            if (currentItem < 3) {
                setCurrentItem(currentItem + 2, true)
            }
        }
        binding.btnStart.setOnClickListener {
            if (binding.viewPager2.currentItem == 2) {
                findNavController().navigate(R.id.noteFragment)
            }
        }
    }


    private fun btnGetStarted() = with(binding) {
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        tvSend.isVisible = true
                        btnStart.isVisible = false
                    }

                    1 -> {
                        tvSend.isVisible = true
                        btnStart.isVisible = false
                    }

                    2 -> {
                        tvSend.isVisible = false
                        btnStart.isVisible = true
                    }
                }
                super.onPageSelected(position)
            }
        })
    }
    private fun openHome() {
        SharedPreference.isOnBoardShown = true
    }
}