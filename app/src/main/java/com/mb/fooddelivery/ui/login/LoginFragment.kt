package com.mb.fooddelivery.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mb.fooddelivery.databinding.FragmentLoginBinding
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import androidx.appcompat.app.AppCompatActivity
import com.mb.fooddelivery.R
import com.mb.fooddelivery.MainActivity





@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
    private val viewModel : LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener{
            loginRequest()
        }

        binding.apply {
            signUpText.setOnClickListener {
                navigate()
            }
        }
    }

    private fun navigate() {
        findNavController().navigate(R.id.action_loginFragment2_to_signupFragment2)
        Log.i("Mert","clicked")
    }

    private fun loginRequest() {
        binding.apply {
            val email = edtTxtUsername.editText?.text.toString()
            val password = edtTxtPassword.editText?.text.toString()

        viewModel.login(email,password).observe(
            viewLifecycleOwner, {
                when(it.status){
                    Resource.Status.LOADING -> {
                        Log.i("Mert","Loading")
                    }
                    Resource.Status.SUCCESS ->{
                        val i = Intent(context, MainActivity::class.java)
                        startActivity(i)
                        requireActivity().finish()
                    }
                    Resource.Status.ERROR ->{
                        Log.i("Mert","Error")
                    }
                }
            }
        )
    } }
}


