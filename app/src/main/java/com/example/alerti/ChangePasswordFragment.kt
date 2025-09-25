package com.example.alerti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ChangePasswordFragment : Fragment() {

    private lateinit var scrollView: ScrollView
    private lateinit var newPasswordField: CustomTextFieldView
    private lateinit var confirmPasswordField: CustomTextFieldView
    private lateinit var changePasswordButton: CustomButtonView
    private lateinit var cancelButton: CustomButtonView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_change_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupViews(view)
        setupListeners()
    }

    private fun setupViews(view: View) {
        scrollView = view.findViewById(R.id.scrollView) ?: view as ScrollView
        newPasswordField = view.findViewById(R.id.newPasswordField)
        confirmPasswordField = view.findViewById(R.id.confirmPasswordField)
        changePasswordButton = view.findViewById(R.id.changePasswordButton)
        cancelButton = view.findViewById(R.id.cancelButton)
    }

    private fun setupListeners() {
        changePasswordButton.onClickListener = {
            showSuccessDialog()
        }
        
        cancelButton.onClickListener = {
            findNavController().navigateUp()
        }
        
    }
    
    private fun showSuccessDialog() {
        val dialog = SuccessDialogFragment.newInstance(
            title = getString(R.string.dialog_password_changed_title),
            buttonText = getString(R.string.dialog_ok_button),
            showButton = true,
            actionType = SuccessDialogFragment.ACTION_TYPE_PASSWORD_CHANGED
        )
        dialog.show(parentFragmentManager, "PasswordChangedDialog")
    }
}
