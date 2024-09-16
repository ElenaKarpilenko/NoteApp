package com.example.noteapplication.ui.fragment.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapplication.App
import com.example.noteapplication.R
import com.example.noteapplication.databinding.FragmentNoteBinding
import com.example.noteapplication.ui.adapter.NoteAdapter
import com.example.noteapplication.utils.SharedPreferenceHelper

class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding
    private lateinit var noteAdapter: NoteAdapter
    private var isGridLayout = false
    private lateinit var sharedPreferenceHelper: SharedPreferenceHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferenceHelper = SharedPreferenceHelper(requireContext())
        isGridLayout = sharedPreferenceHelper.getIsGridLayout()
        noteAdapter = NoteAdapter()
        initialize()
        setUpListeners()
        getData()
    }


    private fun initialize() {
        binding.rvNote.apply {
            layoutManager = if (isGridLayout) {
                GridLayoutManager(requireContext(), 2)
            } else {
                LinearLayoutManager(requireContext())
            }
            adapter = noteAdapter
        }
    }

    private fun updateLayoutButtonIcon() = with(binding) {
        if (isGridLayout) {
            gridLayout.visibility = View.GONE
            linearLayout.visibility = View.VISIBLE
        } else {
            gridLayout.visibility = View.VISIBLE
            linearLayout.visibility = View.GONE
        }
    }

    private fun setUpListeners() = with(binding) {
        addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_detailNoteFragment)
        }
        gridLayout.setOnClickListener {
            isGridLayout = true
            binding.rvNote.layoutManager = GridLayoutManager(requireContext(), 2)
            sharedPreferenceHelper.setIsGridLayout(isGridLayout)
            updateLayoutButtonIcon()
        }
        linearLayout.setOnClickListener {
            isGridLayout = false
            binding.rvNote.layoutManager = LinearLayoutManager(requireContext())
            sharedPreferenceHelper.setIsGridLayout(isGridLayout)
            updateLayoutButtonIcon()
        }
    }

    private fun getData() {
        App().getInstance()?.noteDao()?.getAll()?.observe(viewLifecycleOwner) {
            noteAdapter.submitList(it)
        }

//        getBackStackData<String>("key") { data ->
//            val noteModel = NoteModel(data)
//            list.add(noteModel)
//            noteAdapter.submitList(list)
//        }
    }
}