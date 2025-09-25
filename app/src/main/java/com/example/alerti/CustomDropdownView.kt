package com.example.alerti

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout

class CustomDropdownView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val textInputLayout: TextInputLayout
    private val autoCompleteTextView: MaterialAutoCompleteTextView
    
    private var options: List<String> = emptyList()
    private var onSelectionChangedListener: ((String?) -> Unit)? = null

    var selectedOption: String? = null
        private set

    var label: String? = null
        set(value) {
            field = value
            textInputLayout.hint = value
        }

    var placeholder: String? = null
        set(value) {
            field = value
            textInputLayout.placeholderText = value
        }

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_dropdown, this, true)
        textInputLayout = view.findViewById(R.id.textInputLayout)
        autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView)
        
        setupDropdown()
        attrs?.let { loadAttributesFromXml(it) }
    }

    private fun setupDropdown() {

        autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            if (position < options.size) {
                selectedOption = options[position]
                onSelectionChangedListener?.invoke(selectedOption)
            }
        }
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
