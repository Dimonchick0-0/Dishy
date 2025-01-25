package com.example.dishy.presentation.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dishy.MyDishApplication
import com.example.dishy.R
import com.example.dishy.databinding.FragmentChoosingASpecificDishBinding
import com.example.dishy.databinding.FragmentCommonForDishesBinding
import com.example.dishy.presentation.interfacefragments.ClearBackStack
import com.example.dishy.presentation.recycler.specificalTypeDish.SpecificTypeAdapter
import com.example.dishy.presentation.viewmodel.ViewModelFactory
import com.example.dishy.presentation.viewmodel.fivescreen.SpecificTypeDishViewModel
import javax.inject.Inject

class ChoosingASpecificDishFragment : Fragment(), ClearBackStack {

    private var _binding: FragmentChoosingASpecificDishBinding? = null
    private val binding: FragmentChoosingASpecificDishBinding
        get() = _binding ?: throw RuntimeException("FragmentChoosingASpecificDishBinding == null")

    private val component by lazy {
        (requireActivity().application as MyDishApplication).component
    }

    private val args by navArgs<ChoosingASpecificDishFragmentArgs>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var vm: SpecificTypeDishViewModel

    private lateinit var specificTypeAdapter: SpecificTypeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChoosingASpecificDishBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, viewModelFactory)[SpecificTypeDishViewModel::class.java]
        initAdapter(view.context)
        setupBtnNav()
        clearAllBackStackIsFromFragment()
        addBasket()
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

    private fun setupBtnNav() = with(binding) {
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
        findNavController().navigate(R.id.action_choosingASpecificDishFragment_to_basketFragment)
    }

    private fun launchFragmentChoose() {
        findNavController().navigate(R.id.action_choosingASpecificDishFragment_to_chooseDishFragment)
    }

    private fun initAdapter(context: Context) {
        binding.rcvSpecifingDish.apply {
            layoutManager = LinearLayoutManager(context)
            specificTypeAdapter = SpecificTypeAdapter()
            adapter = specificTypeAdapter
        }
        setupList()
    }

    private fun addBasket() {
        specificTypeAdapter.addDishToBasketClickListener = {
            vm.addToBasket(it)
        }
    }

    private fun setupList() {
        filterDishType()
        vm.dishListLD.observe(viewLifecycleOwner) { specificTypeAdapter.submitList(it) }
    }

    private fun filterDishType() {
        vm.determineTheTypeOfDish(args.specificalTypeDish)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}