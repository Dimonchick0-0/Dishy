package com.example.dishy.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dishy.MyDishApplication
import com.example.dishy.R
import com.example.dishy.databinding.FragmentTypeDishBinding
import com.example.dishy.domain.entity.TypeDish
import com.example.dishy.presentation.recycler.typedishadapter.TypeDishAdapter
import com.example.dishy.presentation.viewmodel.ViewModelFactory
import com.example.dishy.presentation.viewmodel.thirdscreen.TypeDishViewModel
import javax.inject.Inject

class TypeDishFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var vm: TypeDishViewModel

    private var _binding: FragmentTypeDishBinding? = null
    private val binding: FragmentTypeDishBinding
        get() = _binding ?: throw RuntimeException("FragmentTypeDishBinding == null")

    private lateinit var typeDishAdapter: TypeDishAdapter

    private val component by lazy {
        (requireActivity().application as MyDishApplication).component
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTypeDishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, viewModelFactory)[TypeDishViewModel::class.java]
        initAdapter(view.context)
        setTypeDishAdapterToList()
        setupBtnNav()
        clearAllBackStackIsFromFragment()
    }

    private fun clearAllBackStackIsFromFragment() {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity()
                        .supportFragmentManager
                        .popBackStack(null,
                            FragmentManager.POP_BACK_STACK_INCLUSIVE)

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
        findNavController().navigate(R.id.action_typeDishFragment_to_basketFragment)
    }

    private fun launchFragmentChoose() {
        findNavController().navigate(R.id.action_typeDishFragment_to_chooseDishFragment)
    }

    private fun initAdapter(context: Context) {
        binding.rcvTypeDish.apply {
            layoutManager = GridLayoutManager(context, 2)
            typeDishAdapter = TypeDishAdapter()
            adapter = typeDishAdapter
        }
    }

    private fun setTypeDishAdapterToList() {
        vm.typeDishListLD.observe(viewLifecycleOwner) {
            typeDishAdapter.submitList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}