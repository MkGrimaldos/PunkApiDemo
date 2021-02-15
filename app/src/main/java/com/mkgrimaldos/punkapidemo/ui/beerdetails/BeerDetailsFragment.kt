package com.mkgrimaldos.punkapidemo.ui.beerdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mkgrimaldos.punkapidemo.R
import com.mkgrimaldos.punkapidemo.databinding.FragmentBeerDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class BeerDetailsFragment : Fragment() {

    private val args: BeerDetailsFragmentArgs by navArgs()

    private val viewModel: BeerDetailsViewModel by viewModel { parametersOf(args.beerDetails) }

    private var _binding: FragmentBeerDetailsBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBeerDetailsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setObservers() {
        viewModel.beerDetails.observe(viewLifecycleOwner, {
            binding.fabToggleAvailability.text =
                getText(if (it.isAvailable) R.string.mark_beer_unavailable else R.string.mark_beer_available)
        })
    }
}