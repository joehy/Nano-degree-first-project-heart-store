package com.service.hearstore.ui.add_heart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.service.hearstore.R
import com.service.hearstore.data.model.HeartModel
import com.service.hearstore.databinding.FragmentAddHeartBinding
import com.service.hearstore.databinding.WelcomeFragmentBinding
import com.service.hearstore.ui.heart_list.HeartListViewModel

class AddNewHeart : Fragment() {
    private val heartListViewModel: HeartListViewModel by activityViewModels()
    private var _binding: FragmentAddHeartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?):View{
       _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_heart, container, false)
        val root: View = binding.root
        binding.lifecycleOwner = this
        binding.heart = HeartModel()
        binding.save.setOnClickListener {
          if ( heartListViewModel.addNewHeart(binding.heart!!)) {
              heartListViewModel.test()
              view?.findNavController()?.navigate(R.id.action_nav_add_item_to_nav_heart_list)
          }  else
              Log.i("anahna","msh tmam 2oy")
        }
        binding.cancel.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_nav_add_item_to_nav_heart_list)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}