package com.example.roomex.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.roomex.APP
import com.example.roomex.R
import com.example.roomex.databinding.FragmentDetailBinding
import com.example.roomex.databinding.FragmentStartBinding
import com.example.roomex.model.NoteModel
import com.example.roomex.screens.add.AddViewModel


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding
    lateinit var current:NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        current = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.name.text=current.title
        binding.descrition.text=current.description

        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

        binding.btnDelete.setOnClickListener {
            viewModel.delete(current){}
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
        }

    }
}