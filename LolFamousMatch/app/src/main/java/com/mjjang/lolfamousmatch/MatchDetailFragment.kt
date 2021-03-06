package com.mjjang.lolfamousmatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.chip.Chip
import com.mjjang.lolfamousmatch.databinding.FragmentMatchDetailBinding
import com.mjjang.lolfamousmatch.utilities.DynamicStyle
import com.mjjang.lolfamousmatch.utilities.InjectorUtils
import com.mjjang.lolfamousmatch.viewmodels.MatchDetailViewModel

class MatchDetailFragment : Fragment() {

    private val args: MatchDetailFragmentArgs by navArgs()

    private val matchDetailViewModel: MatchDetailViewModel by viewModels {
        InjectorUtils.provideMatchDetailViewModelFactory(this, args.matchId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMatchDetailBinding.inflate(inflater, container, false).apply {
            viewModel = matchDetailViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        context ?: return binding.root

        activity?.onBackPressedDispatcher?.addCallback {
            view?.findNavController()?.navigateUp()
        }

        matchDetailViewModel.match.observe(viewLifecycleOwner, Observer {
            val tagArray = it.tag?.split(",")
            if (tagArray != null) {
                for (tag in tagArray) {
                    val chip = Chip(activity)
                    chip.text = "#$tag"
                    DynamicStyle.setChipStyle(chip)
                    binding.layoutChipGroup.addView(chip)
                }
            }
        })

        return binding.root
    }


}