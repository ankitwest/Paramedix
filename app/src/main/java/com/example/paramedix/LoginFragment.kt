package com.example.paramedix

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class LoginFragment: Fragment() {

    private lateinit var loginIdHead: MaterialTextView;
    private lateinit var passHead: MaterialTextView;
    private lateinit var btnLogin: MaterialButton;
    private lateinit var newAccount: MaterialTextView;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        var rootView: View = inflater.inflate(R.layout.fragment_login, container, false)!!
        loginIdHead=rootView.findViewById(R.id.id_head)
        passHead=rootView.findViewById(R.id.pass_head)
        btnLogin=rootView.findViewById<MaterialButton>(R.id.btnLogin)
        newAccount=rootView.findViewById(R.id.create_new_ac)

        btnLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Toast.makeText(activity?.applicationContext," Hello Login Fella", Toast.LENGTH_SHORT).show()
            }

        });
        newAccount.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Toast.makeText(activity?.applicationContext," Hey There!", Toast.LENGTH_SHORT).show()
                val intent = Intent(context,SignUp::class.java)
                startActivity(intent)
            }

        });

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
/*
    fun showToast (view: View) {
        Toast.makeText(activity?.applicationContext," Hello Login Fella", Toast.LENGTH_LONG).show()
    }
    fun goToSignUp(v: View?) {
        val intent = Intent(context,SignUp::class.java)
        startActivity(intent)
    }
 */

}
