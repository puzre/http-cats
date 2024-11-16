package com.puzre.httpcats.ui.pickcode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.puzre.httpcats.databinding.FragmentPickCodeBinding

class PickCodeFragment : Fragment(), PickCodeViewEvents {

    private val viewModel: PickCodeViewModel by viewModels()

    private var _binding: FragmentPickCodeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPickCodeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewEvents = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, Observer {

            when (it.nextIntent) {

                is PickCodeIntent.OnGoToImageFragmentIntent -> goToImageFragment(it.nextIntent.httpCodeTypeIndex)
                else -> {}

            }
        }
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.onIntent(PickCodeIntent.OnResetStateIntent)
    }

    private fun goToImageFragment(httpCodeIndex: Int) {

        Navigation.findNavController(binding.root)
            .navigate(PickCodeFragmentDirections.pickCodeFragmentToImageFragment(httpCodeIndex))

    }

    override fun onClickInformational(view: View) {
        viewModel.onIntent(
            PickCodeIntent.OnClickHttpCodeButtonIntent(
                httpCodeTypeIndex = 0
            )
        )
    }

    override fun onClickSuccessful(view: View) {
        viewModel.onIntent(
            PickCodeIntent.OnClickHttpCodeButtonIntent(
                httpCodeTypeIndex = 1
            )
        )
    }

    override fun onClickRedirection(view: View) {
        viewModel.onIntent(
            PickCodeIntent.OnClickHttpCodeButtonIntent(
                httpCodeTypeIndex = 2
            )
        )
    }

    override fun onClickClientError(view: View) {
        viewModel.onIntent(
            PickCodeIntent.OnClickHttpCodeButtonIntent(
                httpCodeTypeIndex = 3
            )
        )
    }

    override fun onClickServerError(view: View) {
        viewModel.onIntent(
            PickCodeIntent.OnClickHttpCodeButtonIntent(
                httpCodeTypeIndex = 4
            )
        )
    }

}