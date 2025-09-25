package com.example.alerti

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.TextView
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class CustomDropdownView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val labelTextView: TextView
    private val autoCompleteTextView: MaterialAutoCompleteTextView
    
    private var options: List<String> = emptyList()
    private var onSelectionChangedListener: ((String?) -> Unit)? = null

    var selectedOption: String? = null
        private set

    var label: String? = null
        set(value) {
            field = value
            updateLabel()
        }

    var placeholder: String? = null
        set(value) {
            field = value
            autoCompleteTextView.hint = value
        }

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_dropdown, this, true)
        labelTextView = view.findViewById(R.id.labelTextView)
        autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView)
        
        setupDropdown()
        attrs?.let { loadAttributesFromXml(it) }
    }

    private fun setupDropdown() {
        // Hacer que el AutoCompleteTextView funcione como dropdown
        autoCompleteTextView.setOnClickListener {
            autoCompleteTextView.showDropDown()
        }

        autoCompleteTextView.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                autoCompleteTextView.showDropDown()
            }
        }

        autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            if (position < options.size) {
                val selectedOption = options[position]
                this.selectedOption = selectedOption
                autoCompleteTextView.setText(selectedOption, false)
                autoCompleteTextView.dismissDropDown()
                autoCompleteTextView.clearFocus()
                onSelectionChangedListener?.invoke(selectedOption)
            }
        }

        // Prevenir que se pueda escribir en el campo
        autoCompleteTextView.keyListener = null
        autoCompleteTextView.threshold = 0
    }

    private fun loadAttributesFromXml(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomDropdownView)
        try {
            label = typedArray.getString(R.styleable.CustomDropdownView_dropdownLabel)
            placeholder = typedArray.getString(R.styleable.CustomDropdownView_dropdownPlaceholder)
            
            // Cargar opciones desde recursos si está definido
            val optionsArrayId = typedArray.getResourceId(R.styleable.CustomDropdownView_dropdownOptions, -1)
            if (optionsArrayId != -1) {
                val optionsArray = context.resources.getStringArray(optionsArrayId)
                setOptions(optionsArray.toList())
            }
        } finally {
            typedArray.recycle()
        }
    }

    private fun updateLabel() {
        if (label.isNullOrEmpty()) {
            labelTextView.visibility = View.GONE
        } else {
            labelTextView.text = label
            labelTextView.visibility = View.VISIBLE
        }
    }

    fun setOptions(options: List<String>) {
        this.options = options
        updateAdapter()
    }

    private fun updateAdapter() {
        val adapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, options)
        autoCompleteTextView.setAdapter(adapter)
    }

    fun setOnSelectionChangedListener(listener: (String?) -> Unit) {
        this.onSelectionChangedListener = listener
    }

    fun getSelectedValue(): String? = selectedOption
}
