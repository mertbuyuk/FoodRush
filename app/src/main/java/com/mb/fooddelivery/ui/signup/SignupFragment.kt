package com.mb.fooddelivery.ui.signup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mb.fooddelivery.R
import com.mb.fooddelivery.databinding.FragmentSignupBinding
import com.mb.fooddelivery.model.data.signup.SignupRequest
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignupFragment : Fragment() {
    private lateinit var binding : FragmentSignupBinding
    private val viewModel : SignupViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signBtn.setOnClickListener { userRequest() }

        binding.LoginText.setOnClickListener {
            navigate()
        }
    }

    private fun navigate() {
        findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        Log.i("Mert","cşi,cked")
    }

    private fun userRequest() {
        binding.apply {
            val username = edtTxtUsername.editText?.text.toString()
            val name = edtTxtName.editText?.text.toString()
            val surname = edtTxtSurname.editText?.text.toString()
            val email = edtTxtEmail.editText?.text.toString()
            val password = edtTxtpass.editText?.text.toString()

            val signupRequest = SignupRequest(name, surname, username, email, password)

            viewModel.signup(signupRequest).observe(viewLifecycleOwner,{
                when(it.status){
                    Resource.Status.SUCCESS -> {
                        findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
                        Toast.makeText(requireContext(),"You can login now!",Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}