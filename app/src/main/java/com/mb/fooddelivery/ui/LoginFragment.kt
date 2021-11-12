package com.mb.fooddelivery.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mb.fooddelivery.databinding.FragmentLoginBinding
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

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
    }

    private fun loginRequest() {
        binding.apply {
            val email = edtTxtUsername.text.toString()
            val password = edtTxtPassword.text.toString()

        viewModel.login(email,password).observe(
            viewLifecycleOwner, {
                when(it.status){
                    Resource.Status.LOADING -> {
                        Log.i("Mert","Loading")
                    }
                    Resource.Status.SUCCESS ->{
                        Log.i("Mert","Başarılı")
                    }
                    Resource.Status.ERROR ->{
                        Log.i("Mert","Error")
                    }
                }
            }
        )
    } }
}


