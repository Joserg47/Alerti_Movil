package com.example.alerti

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.TextInputEditText

class CustomTextFieldView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val textInputLayout: TextInputLayout
    private val textInputEditText: TextInputEditText

    var value: String
        get() = textInputEditText.text.toString()
        set(value) = textInputEditText.setText(value)

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_text_field, this, true)
        textInputLayout = view.findViewById(R.id.textInputLayout)
        textInputEditText = view.findViewById(R.id.textInputEditText)
        attrs?.let { loadAttributesFromXml(it) }
    }

    private fun loadAttributesFromXml(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextFieldView)
        try {
            textInputLayout.hint = typedArray.getString(R.styleable.CustomTextFieldView_label)
            
            val placeholder = typedArray.getString(R.styleable.CustomTextFieldView_placeholder)
            textInputLayout.placeholderText = if (placeholder != null && placeholder.length > 25) {
                "${placeholder.take(22)}..."
            } else {
                placeholder
            }
            
            val inputType = typedArray.getString(R.styleable.CustomTextFieldView_inputType)
            textInputEditText.inputType = when (inputType?.lowercase()) {
                "password" -> InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                "email" -> InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                else -> InputType.TYPE_CLASS_TEXT
            }
        } finally {
            typedArray.recycle()
        }
    }
}