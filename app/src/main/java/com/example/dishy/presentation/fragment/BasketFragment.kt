package com.example.dishy.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dishy.MyDishApplication
import com.example.dishy.R
import com.example.dishy.databinding.FragmentBasketBinding
import com.example.dishy.presentation.recycler.basketadapter.DishBasketAdapter
import com.example.dishy.presentation.viewmodel.ViewModelFactory
import com.example.dishy.presentation.viewmodel.secondscreen.BasketDishViewModel
import javax.inject.Inject

class BasketFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentBasketBinding? = null
    private val binding: FragmentBasketBinding
        get() = _binding ?: throw RuntimeException("FragmentBasketBinding = null")

    private val component by lazy {
        (requireActivity().application as MyDishApplication).component
    }

    private lateinit var dishBasketAdapter: DishBasketAdapter
    private lateinit var vm: BasketDishViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBasketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, viewModelFactory)[BasketDishViewModel::class.java]
        initAdapter(view.context)
        setupBtnNav()
        deleteDishItem()
        observeViewModel()
        clearAllBackStackIsFromFragment()
        Log.d("BasketFragmentBackStack", "onViewCreated")
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
            recycledViewPool.setMaxRecycledViews(
                DishBasketAdapter.TYPE_VIEW,
                DishBasketAdapter.MAX_VIEW_POOL
            )
            setupBasketList()
        }
    }

    private fun setupBtnNav() = with(binding) {
        btnNavMenu.selectedItemId = R.id.dishBasket
        btnNavMenu.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.dishHome -> launchChooseDishFrag()
                R.id.dishSearch -> launchFragmentTypeDish()
            }
            true
        }
    }

    private fun deleteDishItem() {
        dishBasketAdapter.onItemDeleteClickListener = {
            vm.deleteItem(it)
        }
    }

    private fun launchChooseDishFrag() {
        findNavController().navigate(R.id.action_basketFragment_to_chooseDishFragment)
    }

    private fun launchFragmentTypeDish() {
        findNavController().navigate(R.id.action_basketFragment_to_typeDishFragment)
    }

    private fun clearAllBackStackIsFromFragment() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity()
                        .supportFragmentManager
                        .popBackStack()

                    if (isEnabled) {
                        isEnabled = false
                        requireActivity().onBackPressedDispatcher.onBackPressed()
                    }
                }
            })
    }

    private fun observeViewModel() {
        vm.loadAllDish.observe(viewLifecycleOwner) {
            val resultSum = it.sumOf { dishPrice ->
                dishPrice.priceDish
            }
            binding.tvSumBasket.text = String.format("%s", resultSum)
            vm.sumAllPriceDish(binding.tvSumBasket.text.toString().toInt())
        }
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