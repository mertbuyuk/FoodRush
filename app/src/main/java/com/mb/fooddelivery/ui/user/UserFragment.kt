package com.mb.fooddelivery.ui.user

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.mb.fooddelivery.R
import com.mb.fooddelivery.databinding.FragmentUserBinding
import com.mb.fooddelivery.model.data.user.UserBody
import com.mb.fooddelivery.model.data.user.UserRequest
import com.mb.fooddelivery.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UserFragment : Fragment() {
    private lateinit var binding : FragmentUserBinding
    private val viewModel : UserViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUser()
        binding.updateBtn.setOnClickListener {
            updateUser()
        }
    }

    private fun updateUser() {
        binding.apply {
            val name = outlinedTextField.editText?.text.toString()
            val surname = outlinedsurname.editText?.text.toString()
            val email = outlinedemail.editText?.text.toString()
            val addres = outlineAdress.editText?.text.toString()
            val username = outlinedusername.editText?.text.toString()
            val password = outlinepassword.editText?.text.toString()
            val phone = outlinePhone.editText?.text.toString()
            val user = UserRequest(name,surname,email,username,password,addres,phone)

            viewModel.editUserSettings(user).observe(viewLifecycleOwner,{

                when(it.status){
                    Resource.Status.SUCCESS ->{
                        Toast.makeText(requireContext(),"Updated!",Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.global_home)
                    }
                }
            })
        }
    }

    private fun getUser() {
        viewModel.getUser().observe(viewLifecycleOwner,{
            when(it.status){
                Resource.Status.SUCCESS -> onSucces(it.data!!.responseBody)
            }
        })
    }

    private fun onSucces(responseBody: UserBody) {
        binding.apply {
            //TODO
            outlinedTextField.editText?.setText(responseBody.name)
            outlinedsurname.editText?.setText(responseBody.surname)
            outlinedemail.editText?.setText(responseBody.email)
            outlinedusername.editText?.setText(responseBody.username)
            outlinepassword.editText?.setText(responseBody.password)
            outlineAdress.editText?.setText(responseBody.address)
            outlinePhone.editText?.setText(responseBody.phone)
        }
    }
}