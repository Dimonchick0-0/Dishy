package com.example.dishy.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dishy.R
import com.example.dishy.databinding.FragmentChooseDishBinding

class ChooseDishFragment : Fragment() {

    private var _binding: FragmentChooseDishBinding? = null
    private val binding: FragmentChooseDishBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseDishBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseDishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}