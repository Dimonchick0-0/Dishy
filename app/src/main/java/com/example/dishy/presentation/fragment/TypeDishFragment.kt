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
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dishy.MyDishApplication
import com.example.dishy.R
import com.example.dishy.databinding.FragmentTypeDishBinding
import com.example.dishy.domain.emun.DishyType
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.entity.Dishy
import com.example.dishy.presentation.interfacefragments.ClearBackStack
import com.example.dishy.presentation.recycler.typedishadapter.TypeDishAdapter
import com.example.dishy.presentation.viewmodel.ViewModelFactory
import com.example.dishy.presentation.viewmodel.thirdscreen.TypeDishViewModel
import javax.inject.Inject

class TypeDishFragment : Fragment(), ClearBackStack {

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
        switchingToASpecificTypeOfDish()
    }

    override fun clearAllBackStackIsFromFragment() {
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

    private fun switchingToASpecificTypeOfDish() {
        typeDishAdapter.onItemClickListener = {
            findNavController().apply {
                val action = TypeDishFragmentDirections
                    .actionTypeDishFragmentToCommonFragmentForDishes(it.dishyType)
                navigate(action)
            }
        }
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
        vm.dishyListLD.observe(viewLifecycleOwner) {
            typeDishAdapter.submitList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val TYPE_DISH = "type_dish"
        private const val MODE_SCREEN = "mode_screen"
        private const val TYPE_DISH_ID = "type_dish_id"

        fun newInstance(itemId: Int): TypeDishFragment {
            return TypeDishFragment().apply {
                arguments = Bundle().apply {
                    putString(MODE_SCREEN, TYPE_DISH)
                    putInt(TYPE_DISH_ID, itemId)
                }
            }
        }
    }
}