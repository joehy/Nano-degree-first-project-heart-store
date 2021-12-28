package com.service.hearstore.ui.heart_list

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.service.hearstore.data.model.HeartModel
import com.service.hearstore.databinding.FragmentHeartListBinding
import com.service.hearstore.R
class HeartListFragment : Fragment() {

    private val heartListViewModel: HeartListViewModel by activityViewModels()
    private var _binding: FragmentHeartListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_heart_list,container, false)
        val root: View = binding.root
        binding.lifecycleOwner = this
        binding.fab.setOnClickListener {
            it?.findNavController()?.navigate(R.id.action_nav_heart_list_to_nav_add_item2)
        }
        heartListViewModel.getHeartLiveData().observe(viewLifecycleOwner, {
            Log.i("anahna","grb de kda ${it.isEmpty()}")
            createHeart(it)
        })
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                binding.root.findNavController().navigate(R.id.action_nav_heart_list_to_loginFragment)
            }
        })
        return root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.navigationpage, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout-> binding.root.findNavController().navigate(R.id.action_nav_heart_list_to_loginFragment)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun createHeart(hearts: List<HeartModel>) {
        Log.i("anahna","grb de kda ${hearts.size}")
        context?.let { context ->
            val heartContainer = binding.list
            hearts.forEach { heart ->
                val heartLayout = HeartLayout(context)
                heartLayout.loadHeart(heart)
                heartContainer.addView(heartLayout)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}