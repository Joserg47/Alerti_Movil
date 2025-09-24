package com.example.alerti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class AlarmDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alarm_detail, container, false)

        view.findViewById<MaterialButton>(R.id.btnConfirmar).setOnClickListener {
        }

        view.findViewById<MaterialButton>(R.id.btnPosponer).setOnClickListener {
        }

        return view
    }
}