package com.example.dishy.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dishy.R
import com.example.dishy.databinding.FragmentChooseDishBinding
import com.example.dishy.presentation.recycler.DishAdapter
import com.example.dishy.presentation.viewmodel.ChooseDishViewModel
import com.example.dishy.presentation.viewmodel.MainViewModelFactory

class ChooseDishFragment : Fragment() {

    private var _binding: FragmentChooseDishBinding? = null
    private val binding: FragmentChooseDishBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseDishBinding == null")

    private val vm by lazy {
        ViewModelProvider(
            this,
            MainViewModelFactory()
        )[ChooseDishViewModel::class.java]
    }

    private lateinit var dishAdapter: DishAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseDishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDishList()
        initAdapter(view.context)
    }

    private fun setupDishList() {
        vm.dishList.observe(viewLifecycleOwner) {
            dishAdapter.submitList(it)
        }
    }

    private fun initAdapter(context: Context) {
        binding.rcvDish.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false)
            dishAdapter = DishAdapter()
            adapter = dishAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}