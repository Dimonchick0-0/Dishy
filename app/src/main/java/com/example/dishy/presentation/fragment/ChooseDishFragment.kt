package com.example.dishy.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dishy.MyDishApplication
import com.example.dishy.R
import com.example.dishy.databinding.FragmentChooseDishBinding
import com.example.dishy.presentation.recycler.dishAdapter.DishAdapter
import com.example.dishy.presentation.viewmodel.ViewModelFactory
import com.example.dishy.presentation.viewmodel.firstscreen.ChooseDishViewModel
import javax.inject.Inject

class ChooseDishFragment : Fragment() {
    private var _binding: FragmentChooseDishBinding? = null
    private val binding: FragmentChooseDishBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseDishBinding == null")

    private lateinit var dishAdapter: DishAdapter
    private lateinit var vm: ChooseDishViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

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
        _binding = FragmentChooseDishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, viewModelFactory)[ChooseDishViewModel::class.java]
        initAdapter(view.context)
        addDishToBasket()
        setupBtnNav()
        val fragment = DifferentDishesFragment()
        childFragmentManager.beginTransaction().apply {
            replace(R.id.different_fragment_container, fragment).commitNow()
        }
        clearBackstack()
    }

    private fun clearBackstack() {
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
        btnNavMenu.selectedItemId = R.id.dishHome
        btnNavMenu.setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.dishBasket -> launchFragmentBasket()
                    R.id.dishSearch -> launchFragmentTypeDish()
                }
            true
        }
    }

    private fun launchFragmentBasket() {
        findNavController().navigate(R.id.action_chooseDishFragment_to_basketFragment)
    }

    private fun launchFragmentTypeDish() {
        findNavController().navigate(R.id.action_chooseDishFragment_to_typeDishFragment)
    }

    private fun setupDishList() {
        vm.dishList.observe(viewLifecycleOwner) { dish ->
            dishAdapter.submitList(dish)
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
            setupDishList()
        }
    }

    private fun addDishToBasket() {
        dishAdapter.addItemClickListener = {
            vm.addDishToBasket(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val NAME_CHOOSE = "choose_frag"
    }
}