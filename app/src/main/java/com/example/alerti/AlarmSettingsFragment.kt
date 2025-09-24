package com.example.alerti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AlarmSettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alarm_settings, container, false)

        view.findViewById<Button>(R.id.btnCancelar).setOnClickListener {
            findNavController().navigateUp()
        }

        view.findViewById<Button>(R.id.btnGuardar).setOnClickListener {
            findNavController().navigateUp()
        }

        return view
    }
}