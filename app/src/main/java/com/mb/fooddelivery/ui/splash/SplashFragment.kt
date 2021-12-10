package com.mb.fooddelivery.ui.splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mb.fooddelivery.databinding.FragmentSplashBinding
import android.util.Log
import androidx.navigation.fragment.findNavController
import com.mb.fooddelivery.MainActivity
import com.mb.fooddelivery.R


class SplashFragment : Fragment() {
    private lateinit var binding : FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
           initAnim()
    }

    private fun initAnim() {
        binding.splashAnim.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                findNavController().navigate(R.id.action_splashFragment2_to_loginFragment2)
                /*val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()*/
            }

            override fun onAnimationCancel(p0: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationRepeat(p0: Animator?) {}

        })
    }

}