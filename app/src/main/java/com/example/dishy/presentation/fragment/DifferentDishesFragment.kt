package com.example.dishy.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dishy.MyApplication
import com.example.dishy.databinding.FragmentDifferentDishesBinding
import com.example.dishy.presentation.recycler.differentAdapter.DifferentDishAdapter
import com.example.dishy.presentation.viewmodel.ViewModelFactory
import com.example.dishy.presentation.viewmodel.firstscreen.ChooseDishViewModel
import javax.inject.Inject

class DifferentDishesFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentDifferentDishesBinding? = null

    private val binding: FragmentDifferentDishesBinding
        get() = _binding ?: throw RuntimeException("FragmentDifferentDishesBinding = null")

    private val component by lazy {
        (requireActivity().application as MyApplication).component
    }

    private lateinit var vm: ChooseDishViewModel
    private lateinit var differentDishAdapter: DifferentDishAdapter
    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDifferentDishesBinding.inflate(
            layoutInflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this, viewModelFactory)[ChooseDishViewModel::class.java]
        setRCV(view.context)
        addDifferentDishToBasket()
    }

    private fun setRCV(context: Context) {
        binding.rcvDifferentDish.apply {
            layoutManager = GridLayoutManager(context, 2)
            differentDishAdapter = DifferentDishAdapter()
            adapter = differentDishAdapter
            setupList()
        }
    }

    private fun setupList() {
        vm.differentDishList.observe(viewLifecycleOwner) {
            differentDishAdapter.submitList(it)
        }
    }

    private fun addDifferentDishToBasket() {
        differentDishAdapter.onAddItemClickListener = {
            TODO() // Сделать добавку в корзину
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}