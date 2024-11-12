package com.example.dishy.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dishy.databinding.FragmentChooseDishBinding
import com.example.dishy.di.app.DaggerApplicationComponent
import com.example.dishy.presentation.recycler.DishAdapter
import com.example.dishy.presentation.viewmodel.ChooseDishViewModel
import com.example.dishy.presentation.viewmodel.lazyViewModel

class ChooseDishFragment : Fragment() {

    private val component by lazy {
        DaggerApplicationComponent.builder()
            .application(requireActivity().application)
            .build()
    }

    private val vm: ChooseDishViewModel by lazyViewModel { stateHandle ->
        component.getChooseDishViewModel().create(stateHandle)
    }

    private var _binding: FragmentChooseDishBinding? = null
    private val binding: FragmentChooseDishBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseDishBinding == null")

    private lateinit var dishAdapter: DishAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseDishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        component.inject(this)
        super.onViewCreated(view, savedInstanceState)
        setupDishList()
        initAdapter(view.context)
        addDishToBasket()
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

    private fun addDishToBasket() {
        dishAdapter.onItemClickListener = {
            vm.addDish(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}