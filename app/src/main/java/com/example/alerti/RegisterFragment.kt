package com.example.alerti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class RegisterFragment : Fragment() {

    private lateinit var scrollView: ScrollView
    private lateinit var nameField: CustomTextFieldView
    private lateinit var birthDateField: CustomTextFieldView
    private lateinit var genderDropdown: CustomDropdownView
    private lateinit var phoneField: CustomTextFieldView
    private lateinit var usernameField: CustomTextFieldView
    private lateinit var passwordField: CustomTextFieldView
    private lateinit var registerButton: CustomButtonView
    private lateinit var loginLink: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupViews(view)
        setupListeners()
    }

    private fun setupViews(view: View) {
        scrollView = view.findViewById(R.id.scrollView) ?: view as ScrollView
        nameField = view.findViewById(R.id.nameField)
        birthDateField = view.findViewById(R.id.birthDateField)
        genderDropdown = view.findViewById(R.id.genderDropdown)
        phoneField = view.findViewById(R.id.phoneField)
        usernameField = view.findViewById(R.id.usernameField)
        passwordField = view.findViewById(R.id.passwordField)
        registerButton = view.findViewById(R.id.registerButton)
        loginLink = view.findViewById(R.id.loginLink)
        
        setupGenderDropdown()
    }

    private fun setupGenderDropdown() {
        // Las opciones ya están configuradas desde el XML con el array gender_options
        genderDropdown.setOnSelectionChangedListener { selectedGender ->
            // Aquí puedes manejar la selección del género si necesitas
            // Por ejemplo: Log.d("RegisterFragment", "Gender selected: $selectedGender")
        }
    }

    private fun setupListeners() {
        registerButton.onClickListener = {
            findNavController().navigate(R.id.action_register_to_login)
        }

        loginLink.setOnClickListener {
            findNavController().navigate(R.id.action_register_to_login)
        }
        
        // Mejorar scroll automático cuando se enfocan campos
        setupAutoScrollForFields()
    }
    
    private fun setupAutoScrollForFields() {
        val fields = listOf(nameField, birthDateField, phoneField, usernameField, passwordField)
        
        fields.forEach { field ->
            field.findViewById<android.widget.EditText>(R.id.textInputEditText)
                ?.setOnFocusChangeListener { view, hasFocus ->
                    if (hasFocus) {
                        view.post {
                            scrollToView(view)
                        }
                    }
                }
        }
    }
    
    private fun scrollToView(view: View) {
        val scrollView = this.scrollView
        val location = IntArray(2)
        view.getLocationInWindow(location)
        
        scrollView.post {
            scrollView.smoothScrollTo(0, location[1] - 200) // 200px de padding superior
        }
    }
}

