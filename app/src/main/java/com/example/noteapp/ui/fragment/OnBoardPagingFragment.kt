package com.example.noteapp.ui.fragment

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardPagingBinding


class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagingBinding.inflate(inflater,container,false)
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
                lottie.setAnimation(R.raw.lottie2)
            }

            1 -> {
                tvTitle.text = "Организация"
                tvOn.text = "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."
                lottie.setAnimation(R.raw.lottie2)
                circle1.setImageResource(R.drawable.circle2)
                circle2.setImageResource(R.drawable.circle)
            }

            2 -> {
                tvTitle.text = "Синхронизация"
                tvOn.text = "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте"
                lottie.setAnimation(R.raw.lottie2)
                circle1.setImageResource(R.drawable.circle2)
                circle2.setImageResource(R.drawable.circle2)
                circle3.setImageResource(R.drawable.circle)

            }
        }
    }

    companion object {
        const val ARG_ONBOARD_POSITION = "yyyyyyy"
    }
}
