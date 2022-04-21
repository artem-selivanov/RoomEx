package com.example.roomex.screens.start

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.roomex.APP
import com.example.roomex.R
import com.example.roomex.adapter.NoteAdapter
import com.example.roomex.databinding.ActivityMainBinding
import com.example.roomex.databinding.FragmentStartBinding
import com.example.roomex.model.NoteModel

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var noteAdapter: NoteAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rvTable
        noteAdapter = NoteAdapter()
        recyclerView.adapter = noteAdapter
        viewModel.getAllNotes().observe(viewLifecycleOwner, { listNotes ->
            noteAdapter.setList(listNotes.asReversed())
        })

        binding.btnStartAdd.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addFragment)
        }

    }

    companion object {
        fun clickNote(noteModel: NoteModel){
            val bundle=Bundle()
            bundle.putSerializable("note",noteModel)
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment,bundle)
        }
    }
}