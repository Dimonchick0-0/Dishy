package com.example.dishy.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dishy.R
import com.example.dishy.databinding.FragmentInvitationBinding

class InvitationFragment : Fragment() {

    private var _binding: FragmentInvitationBinding? = null
    private val binding: FragmentInvitationBinding
        get() = _binding ?: throw RuntimeException("FragmentInvitationBinding == null")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInvitationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnChoose.setOnClickListener {
            launchChooseDishFragment()
        }
    }

    private fun launchChooseDishFragment() {
        findNavController().navigate(R.id.action_invitationFragment2_to_chooseDishFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val HOME_FRAGMENT = "homeFragment"
    }
}