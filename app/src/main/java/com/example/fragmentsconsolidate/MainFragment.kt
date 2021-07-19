package com.example.fragmentsconsolidate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.fragmentsconsolidate.databinding.FragmentMainBinding

class MainFragment : Fragment(){

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.viewTransactionsBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_viewTransactionFragment)
        }
        binding.sendMoneyBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
        }
        binding.viewBalanceBtn.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }
}