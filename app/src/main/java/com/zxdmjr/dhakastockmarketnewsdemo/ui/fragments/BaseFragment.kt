package com.zxdmjr.dhakastockmarketnewsdemo.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import com.zxdmjr.dhakastockmarketnewsdemo.ui.activities.MainViewModel

abstract class BaseFragment<VB: ViewBinding>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding!!

    protected val viewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = initializeViewBinding(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected abstract fun initializeViewBinding(view: View): VB


}