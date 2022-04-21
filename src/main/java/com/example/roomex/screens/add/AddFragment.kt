package com.example.roomex.screens.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.roomex.APP
import com.example.roomex.R
import com.example.roomex.databinding.FragmentAddBinding
import com.example.roomex.databinding.FragmentStartBinding
import com.example.roomex.model.NoteModel


class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddViewModel::class.java)
        binding.btnAdd.setOnClickListener {
            val title2 = binding.nameEdit.text.toString()
            val description2 = binding.descritionEdit.text.toString()
            //val add:NoteModel = NoteModel(title)
                        //NoteModel(title = title, description = description)

            viewModel.insert(NoteModel(title = title2, description = description2)){}
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }
        binding.btnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_addFragment_to_startFragment)
        }
    }
}