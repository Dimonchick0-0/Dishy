package com.example.dishy.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dishy.MyDishApplication
import com.example.dishy.databinding.FragmentCommonForDishesBinding
import com.example.dishy.domain.emun.DishyType
import com.example.dishy.domain.entity.Dish
import com.example.dishy.domain.entity.Dishy
import com.example.dishy.presentation.recycler.dishAdapter.DishAdapter
import com.example.dishy.presentation.viewmodel.ViewModelFactory
import com.example.dishy.presentation.viewmodel.fourscreen.CommonForDishViewModel
import javax.inject.Inject

class CommonFragmentForDishes : Fragment() {

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

    private lateinit var dishAdapter: DishAdapter

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
    }

    private fun initAdapter(context: Context) {
        binding.rcvCommonDish.apply {
            layoutManager = LinearLayoutManager(context)
            dishAdapter = DishAdapter()
            adapter = dishAdapter
        }
        setListTest()
    }

    private fun setListTest() {
        vm.determineTheTypeOfDish(args.dishyTypeEnum)
        vm.dishListLD.observe(viewLifecycleOwner) { dishAdapter.submitList(it) }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}