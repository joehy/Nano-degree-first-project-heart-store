package com.service.hearstore.ui.instructions
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.service.hearstore.R
import com.service.hearstore.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: InstructionsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.instructions_fragment, container, false)
        binding.instructionsNextButton.setOnClickListener {
            findNavController().navigate(R.id.action_instructionsFragment_to_nav_heart_list)
        }
        return binding.root
    }
}