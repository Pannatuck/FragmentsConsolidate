package com.example.fragmentsconsolidate

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.fragmentsconsolidate.databinding.FragmentMainBinding
import com.example.fragmentsconsolidate.databinding.FragmentSpecifyAmountBinding
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(){

    private var _binding: FragmentSpecifyAmountBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpecifyAmountBinding.inflate(inflater, container, false)
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
        val message = "Sendind money to $recipient"
        binding.recipient.text = message

        binding.sendBtn.setOnClickListener{
            if (!TextUtils.isEmpty(binding.inputAmount.text.toString())){
                val amount = Money(BigDecimal(binding.inputAmount.text.toString()))
                val bundle = bundleOf(
                    "recipient" to recipient,
                    "amount" to amount
                )
                view.findNavController().navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle)
            }
        }
        binding.cancelBtn.setOnClickListener{
            requireActivity().onBackPressed()
        }
    }
}