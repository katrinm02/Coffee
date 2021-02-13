package com.example.taskcoffe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.taskcoffe.R

class BlankFragment : Fragment() {
    private lateinit var nameEd:EditText
    private lateinit var next:Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_blank, container, false)
        nameEd = v.findViewById(R.id.name_ed)
        next = v.findViewById(R.id.next_f)
        next.setOnClickListener(){
            if (nameEd.text.isNotEmpty()) {
                requireActivity().supportFragmentManager
                    .beginTransaction()
                    .addToBackStack("order")
                    .replace(R.id.frag_cont, OrderFragment().apply {
                        arguments = Bundle().apply {
                            putString("name", nameEd.text.toString())
                        }
                    })
                    .commit()
            } else {
                Toast.makeText(v.context, "Введите ваше имя", Toast.LENGTH_LONG).show()
            }

        }
        return v
    }
}