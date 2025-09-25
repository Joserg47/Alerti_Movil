package com.example.alerti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {

    private lateinit var scrollView: ScrollView
    private lateinit var emailField: CustomTextFieldView
    private lateinit var passwordField: CustomTextFieldView
    private lateinit var loginButton: CustomButtonView
    private lateinit var registerLinkNew: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupViews(view)
        setupListeners()
    }

    private fun setupViews(view: View) {
        scrollView = view.findViewById(R.id.scrollView)
        emailField = view.findViewById(R.id.emailField)
        passwordField = view.findViewById(R.id.passwordField)
        loginButton = view.findViewById(R.id.loginButton)
        registerLinkNew = view.findViewById(R.id.registerLinkNew)
    }

    private fun setupListeners() {
        loginButton.onClickListener = {
            findNavController().navigate(R.id.action_login_to_alarms)
        }

        registerLinkNew.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }
    }
}
