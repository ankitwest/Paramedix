package com.example.paramedix

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.textview.MaterialTextView

class LoginFragment: Fragment() {
    private lateinit var loginIdHead: MaterialTextView;
    private lateinit var passHead: MaterialTextView;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var rootView: View = inflater.inflate(R.layout.fragment_login, container, false)!!
        loginIdHead=rootView.findViewById(R.id.id_head)
        passHead=rootView.findViewById(R.id.pass_head)
        if (requireArguments().getInt("login_type") == 0)
            loginIdHead.setText("Medical Worker ID")
        else loginIdHead.setText("Beneficiary ID")
        passHead.setText("Password")
        return rootView
    }

    companion object {
        fun newInstance(title: String): Fragment {
            val fragment = LoginFragment()
            val args = Bundle()
            args.putString("login_type", title)
            fragment.arguments = args
            return fragment
        }
    }
}
