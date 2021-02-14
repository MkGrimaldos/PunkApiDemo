package com.mkgrimaldos.punkapidemo.ui.beerlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mkgrimaldos.punkapidemo.databinding.BeerListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerListFragment : Fragment() {

    private val viewModel: BeerListViewModel by viewModel()

    private var _binding: BeerListFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BeerListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerView()
        setObservers()
        viewModel.fetchData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun configureRecyclerView() {
        binding.rvBeersList.adapter = BeerListAdapter()
    }

    private fun setObservers() {
        viewModel.beerList.observe(viewLifecycleOwner) {
            (binding.rvBeersList.adapter as? BeerListAdapter)?.apply {
                beerList = it
                notifyDataSetChanged()
            }
        }
    }
}
