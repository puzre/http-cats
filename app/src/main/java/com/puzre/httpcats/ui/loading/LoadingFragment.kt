package com.puzre.httpcats.ui.loading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.puzre.httpcats.databinding.FragmentLoadingBinding

class LoadingFragment : DialogFragment() {

    private var _binding: FragmentLoadingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoadingBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.window?.setBackgroundDrawable(null)
        isCancelable = false
    }

    private fun dismissLoading() {
        if (isAdded && isVisible)
            dismissAllowingStateLoss()
    }

    fun showLoading(showLoading: Boolean, childFragmentManager: FragmentManager) {
        if (showLoading) {
            if (!isVisible && !isAdded)
                show(childFragmentManager, null)
        } else if (isVisible) {
            dismissLoading()
        }
    }

    companion object {
        val instance: LoadingFragment by lazy {
            LoadingFragment()
        }
    }

}