package com.example.alerti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton

class AlarmListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alarm_list, container, false)

        setupRecordatorio(view, 1)
        setupRecordatorio(view, 2)
        setupRecordatorio(view, 3)
        setupRecordatorio(view, 4)
        setupRecordatorio(view, 5)

        return view
    }

    private fun setupRecordatorio(view: View, numero: Int) {
        val cardId = getCardId(numero)
        val editButtonId = getEditButtonId(numero)
        val deleteButtonId = getDeleteButtonId(numero)

        view.findViewById<View>(cardId)?.setOnClickListener {
            findNavController().navigate(R.id.action_to_alarm_detail)
        }

        view.findViewById<MaterialButton>(editButtonId)?.setOnClickListener {
            it?.isClickable = true
            it?.isFocusable = true
            findNavController().navigate(R.id.action_to_alarm_settings)
        }

        view.findViewById<MaterialButton>(deleteButtonId)?.setOnClickListener {
            it?.isClickable = true
            it?.isFocusable = true
            Toast.makeText(requireContext(), "Función de borrado no implementada", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getCardId(numero: Int): Int {
        return when (numero) {
            1 -> R.id.cardRecordatorio1
            2 -> R.id.cardRecordatorio2
            3 -> R.id.cardRecordatorio3
            4 -> R.id.cardRecordatorio4
            5 -> R.id.cardRecordatorio5
            else -> throw IllegalArgumentException("Número de recordatorio no válido")
        }
    }

    private fun getEditButtonId(numero: Int): Int {
        return when (numero) {
            1 -> R.id.btnEditar1
            2 -> R.id.btnEditar2
            3 -> R.id.btnEditar3
            4 -> R.id.btnEditar4
            5 -> R.id.btnEditar5
            else -> throw IllegalArgumentException("Número de recordatorio no válido")
        }
    }

    private fun getDeleteButtonId(numero: Int): Int {
        return when (numero) {
            1 -> R.id.btnBorrar1
            2 -> R.id.btnBorrar2
            3 -> R.id.btnBorrar3
            4 -> R.id.btnBorrar4
            5 -> R.id.btnBorrar5
            else -> throw IllegalArgumentException("Número de recordatorio no válido")
        }
    }
}