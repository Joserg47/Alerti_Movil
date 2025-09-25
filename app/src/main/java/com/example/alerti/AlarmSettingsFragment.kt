package com.example.alerti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.card.MaterialCardView
import android.widget.ImageView
import android.widget.LinearLayout

class AlarmSettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alarm_settings, container, false)

        val cardTonoToggle = view.findViewById<MaterialCardView>(R.id.cardTonoToggle)
        val layoutOpcionesTono = view.findViewById<LinearLayout>(R.id.layoutOpcionesTono)
        val iconArrowTono = view.findViewById<ImageView>(R.id.iconArrowTono)

        cardTonoToggle.setOnClickListener {
            if (layoutOpcionesTono.visibility == View.VISIBLE) {
                layoutOpcionesTono.visibility = View.GONE
                iconArrowTono.rotation = 0f
            } else {
                layoutOpcionesTono.visibility = View.VISIBLE
                iconArrowTono.rotation = 180f
            }
        }

        view.findViewById<Button>(R.id.btnCancelar).setOnClickListener {
            findNavController().navigateUp()
        }

        view.findViewById<Button>(R.id.btnGuardar).setOnClickListener {
            findNavController().navigateUp()
        }

        return view
    }
}