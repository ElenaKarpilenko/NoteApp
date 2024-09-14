package com.example.noteapplication.ui.fragment.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapplication.R
import com.example.noteapplication.databinding.FragmentOnBoardViewPagerBinding

class OnBoardViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardViewPagerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
                tvTitle.text = "Удобство"
                tvOn.text = "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно"
                lottie.setAnimation(R.raw.lottie1)
            }

            1 -> {
                tvTitle.text = "Организация"
                tvOn.text = "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."
                lottie.setAnimation(R.raw.lottie2)
                circle1.setImageResource(R.drawable.ic_style_white)
                circle2.setImageResource(R.drawable.ic_orange_point)
            }

            2 -> {
                tvTitle.text = "Синхронизация"
                tvOn.text = "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте"
                lottie.setAnimation(R.raw.lottie3)
                circle1.setImageResource(R.drawable.ic_style_white)
                circle2.setImageResource(R.drawable.ic_style_white)
                circle3.setImageResource(R.drawable.ic_orange_point)

            }
        }
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }
}