package com.example.dishy.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dishy.MyDishApplication
import com.example.dishy.R
import com.example.dishy.databinding.FragmentCommonForDishesBinding
import com.example.dishy.domain.emun.DishyType
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.entity.Dishy
import com.example.dishy.presentation.interfacefragments.ClearBackStack
import com.example.dishy.presentation.recycler.commonadapter.CommonAdapter
import com.example.dishy.presentation.recycler.dishAdapter.DishAdapter
import com.example.dishy.presentation.viewmodel.ViewModelFactory
import com.example.dishy.presentation.viewmodel.fourscreen.CommonForDishViewModel
import javax.inject.Inject

class CommonFragmentForDishes : Fragment(), ClearBackStack {

    private var _binding: FragmentCommonForDishesBinding? = null
    private val binding: FragmentCommonForDishesBinding
        get() = _binding ?: throw RuntimeException("FragmentCommonForDishesBinding == null")

    private val component by lazy {
        (requireActivity().application as MyDishApplication).component
    }

    private val args by navArgs<CommonFragmentForDishesArgs>()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var vm: CommonForDishViewModel

    private lateinit var commonAdapter: CommonAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCommonForDishesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, viewModelFactory)[CommonForDishViewModel::class]
        initAdapter(view.context)
        switchingToASpecificTypeOfDish()
        setupBtnNavMenu()
        clearAllBackStackIsFromFragment()
    }

    override fun clearAllBackStackIsFromFragment() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    requireActivity().supportFragmentManager.popBackStack()

                    if (isEnabled) {
                        isEnabled = false
                        requireActivity().onBackPressedDispatcher.onBackPressed()
                    }
                }
            })
    }

    private fun setupBtnNavMenu() = with(binding) {
        btnNavMenu.selectedItemId = R.id.dishSearch
        btnNavMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.dishHome -> launchFragmentChoose()
                R.id.dishBasket -> launchFragmentBasket()
            }
            true
        }
    }

    private fun launchFragmentBasket() {
        findNavController().navigate(R.id.action_commonFragmentForDishes_to_basketFragment)
    }

    private fun launchFragmentChoose() {
        findNavController().navigate(R.id.action_commonFragmentForDishes_to_chooseDishFragment)
    }

    private fun initAdapter(context: Context) {
        binding.rcvCommonDish.apply {
            layoutManager = LinearLayoutManager(context)
            commonAdapter = CommonAdapter()
            adapter = commonAdapter
        }
        setListTest()
    }

    private fun setListTest() {
        filterDishType()
        vm.dishListLD.observe(viewLifecycleOwner) { commonAdapter.submitList(it) }
    }

    private fun filterDishType() {
        vm.determineTheTypeOfDish(args.dishyTypeEnum)
    }

    private fun switchingToASpecificTypeOfDish() {
        commonAdapter.onItemClickListener = {
            findNavController().apply {
                val action = CommonFragmentForDishesDirections
                    .actionCommonFragmentForDishesToChoosingASpecificDishFragment(it.differentTypeDish)
                navigate(action)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}