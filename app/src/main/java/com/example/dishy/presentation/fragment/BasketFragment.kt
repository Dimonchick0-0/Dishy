package com.example.dishy.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dishy.R
import com.example.dishy.databinding.FragmentBasketBinding
import com.example.dishy.di.app.DaggerApplicationComponent
import com.example.dishy.domain.entity.Dish
import com.example.dishy.presentation.recycler.basketadapter.DishBasketAdapter
import com.example.dishy.presentation.viewmodel.secondscreen.BasketDishViewModel
import com.example.dishy.presentation.viewmodel.secondscreen.lazyViewModel

class BasketFragment : Fragment() {

    private var _binding: FragmentBasketBinding? = null
    private val binding: FragmentBasketBinding
        get() = _binding ?: throw RuntimeException("FragmentBasketBinding = null")

    private val component by lazy {
        DaggerApplicationComponent.builder()
            .application(requireActivity().application)
            .build()
    }

    private val vm: BasketDishViewModel by lazyViewModel { stateHandle ->
        component.getBasketDishViewModel().create(stateHandle)
    }

    private lateinit var dishBasketAdapter: DishBasketAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBasketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter(view.context)
        setupBtnNav()
    }

    private fun initAdapter(context: Context) {
        binding.rcvDishBasket.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            dishBasketAdapter = DishBasketAdapter()
            adapter = dishBasketAdapter
            setupBasketList()
        }
    }

    private fun setupBtnNav() = with(binding) {
        btnNavMenu.selectedItemId = R.id.dishBasket
        btnNavMenu.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.dishHome -> launchChooseDishFrag()
            }
            true
        }
    }

    private fun launchChooseDishFrag() {
        findNavController().navigate(R.id.action_basketFragment_to_chooseDishFragment)
    }

    private fun setupBasketList() {
        vm.loadAllDish.observe(viewLifecycleOwner) {
            dishBasketAdapter.submitList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}