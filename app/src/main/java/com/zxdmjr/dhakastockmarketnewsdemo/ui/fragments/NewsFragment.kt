package com.zxdmjr.dhakastockmarketnewsdemo.ui.fragments

import android.os.Bundle
import android.view.View
import com.zxdmjr.dhakastockmarketnewsdemo.R
import com.zxdmjr.dhakastockmarketnewsdemo.databinding.LastSevenDaysFragmentBinding
import com.zxdmjr.dhakastockmarketnewsdemo.databinding.NewsFragmentBinding
import com.zxdmjr.dhakastockmarketnewsdemo.internal.toErrorMessage
import com.zxdmjr.dhakastockmarketnewsdemo.ui.adapters.NewsAdapter
import com.zxdmjr.material_utils.Resource
import com.zxdmjr.material_utils.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : BaseFragment<NewsFragmentBinding>(
    R.layout.news_fragment
) {
    @Inject
    lateinit var newsAdapter: NewsAdapter

    override fun initializeViewBinding(view: View) = NewsFragmentBinding.bind(view)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.rvNews.adapter = newsAdapter
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.getNews().observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Success -> {
                    binding.piNews.hide()
                    newsAdapter.differ.submitList(
                        resource.data
                    )
                }
                is Resource.Loading -> {
                    binding.piNews.show()
                }
                is Resource.Failed -> {
                    binding.piNews.hide()
                    requireContext().toast(
                        resource.errorBody.toErrorMessage(resource.message)
                    )
                }
            }
        }
    }
}