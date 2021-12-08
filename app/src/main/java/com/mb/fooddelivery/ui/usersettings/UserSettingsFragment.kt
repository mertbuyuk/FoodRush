package com.mb.fooddelivery.ui.usersettings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mb.fooddelivery.R
import com.mb.fooddelivery.databinding.FragmentUserSettingsBinding
import com.mb.fooddelivery.model.data.user.UserRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserSettingsFragment : Fragment() {

    private lateinit var  binding : FragmentUserSettingsBinding
    private val viewModel : UserSettingsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserSettingsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // val userRequest  = UserRequest("m","")
       // viewModel.editUserSettings()
    }
}