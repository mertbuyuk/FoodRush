package com.mb.fooddelivery.ui.user

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mb.fooddelivery.databinding.FragmentUserBinding
import com.mb.fooddelivery.model.data.user.UserBody
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
            Log.i("Mert",responseBody.toString())
        }
    }
}