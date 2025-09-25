package com.example.alerti

import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SuccessDialogFragment : DialogFragment() {

    companion object {
        private const val ARG_TITLE = "title"
        private const val ARG_BUTTON_TEXT = "button_text"
        private const val ARG_SHOW_BUTTON = "show_button"
        private const val ARG_ACTION_TYPE = "action_type"

        const val ACTION_TYPE_REGISTER = "register"
        const val ACTION_TYPE_PASSWORD_CHANGED = "password_changed"

        fun newInstance(
            title: String = "Tu cuenta ha sido creada exitosamente",
            buttonText: String = "Entrar",
            showButton: Boolean = true,
            actionType: String = ACTION_TYPE_REGISTER
        ): SuccessDialogFragment {
            val fragment = SuccessDialogFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putString(ARG_BUTTON_TEXT, buttonText)
            args.putBoolean(ARG_SHOW_BUTTON, showButton)
            args.putString(ARG_ACTION_TYPE, actionType)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments?.getString(ARG_TITLE) ?: getString(R.string.dialog_account_created_title)
        val buttonText = arguments?.getString(ARG_BUTTON_TEXT) ?: getString(R.string.dialog_enter_button)
        
        val customView = layoutInflater.inflate(R.layout.dialog_success_content, null)
        
        val titleTextView = customView.findViewById<TextView>(R.id.dialogTitle)
        titleTextView.text = title
        
        val dialogButton = customView.findViewById<CustomButtonView>(R.id.dialogButton)
        dialogButton.text = buttonText
        dialogButton.onClickListener = {
            onAction()
        }

        val dialog = MaterialAlertDialogBuilder(requireContext(), R.style.CustomMaterialDialog)
            .setView(customView)
            .setCancelable(false)
            .create()
            
        return dialog
    }

    private fun onAction() {
        val actionType = arguments?.getString(ARG_ACTION_TYPE) ?: ACTION_TYPE_REGISTER
        
        when (actionType) {
            ACTION_TYPE_REGISTER -> {
                findNavController().navigate(R.id.action_register_to_alarm_list)
            }
            ACTION_TYPE_PASSWORD_CHANGED -> {
            }
        }
        dismiss()
    }
}
