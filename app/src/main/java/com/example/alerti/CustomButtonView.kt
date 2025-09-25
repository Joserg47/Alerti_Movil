package com.example.alerti

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.google.android.material.button.MaterialButton

class CustomButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val materialButton: MaterialButton

    var text: String
        get() = materialButton.text.toString()
        set(value) = materialButton.setText(value)

    var onClickListener: (() -> Unit)? = null
        set(value) {
            field = value
            materialButton.setOnClickListener { value?.invoke() }
        }

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_button, this, true)
        materialButton = view.findViewById(R.id.materialButton)
        
        attrs?.let { loadAttributesFromXml(it) }
    }

    private fun loadAttributesFromXml(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomButtonView)
        try {
            text = typedArray.getString(R.styleable.CustomButtonView_buttonText) ?: ""
            
            val variant = typedArray.getString(R.styleable.CustomButtonView_buttonVariant) ?: "primary"
            val size = typedArray.getString(R.styleable.CustomButtonView_buttonSize) ?: "small"
            
            applyVariant(variant)
            applySize(size)
            
        } finally {
            typedArray.recycle()
        }
    }
    
    private fun applyVariant(variant: String) {
        when (variant) {
            "primary" -> {
                materialButton.backgroundTintList = context.getColorStateList(R.color.primary_container)
                materialButton.setTextColor(context.getColor(R.color.on_primary_container))
            }
            "secondary" -> {
                materialButton.backgroundTintList = context.getColorStateList(R.color.secondary_container)
                materialButton.setTextColor(context.getColor(R.color.on_secondary_container))
            }
        }
    }
    
    private fun applySize(size: String) {
        val layoutParams = materialButton.layoutParams
        when (size) {
            "small" -> {
                layoutParams.height = dpToPx(56)
                materialButton.textSize = 14f
            }
            "medium" -> {
                layoutParams.height = dpToPx(64)
                materialButton.textSize = 14f
            }
            "large" -> {
                layoutParams.height = dpToPx(72)
                materialButton.textSize = 16f
            }
        }
        materialButton.layoutParams = layoutParams
    }
    
    private fun dpToPx(dp: Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }
}
