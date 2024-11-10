package com.puzre.httpcats.ui.pickcode

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.puzre.httpcats.R
import com.puzre.httpcats.data.network.service.HttpCatsService
import com.puzre.httpcats.databinding.FragmentPickCodeBinding

class PickCodeFragment : Fragment(), View.OnClickListener {

    private val viewModel: PickCodeViewModel by viewModels()

    private var _binding: FragmentPickCodeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPickCodeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.viewState.observe(viewLifecycleOwner, Observer {


            when(it.nextIntent){

                is PickCodeIntent.OnGoToImageFragment -> goToImageFragment(it.nextIntent.httpCodeIndex)
                else -> {}

                }
            }
        )

        binding.informationalButton.setOnClickListener(this)
        binding.successfulButton.setOnClickListener(this)
        binding.redirectionButton.setOnClickListener(this)
        binding.clientErrorButton.setOnClickListener(this)
        binding.serverErrorButton.setOnClickListener(this)

    }

    override fun onDestroyView() {
        super.onDestroyView()

        viewModel.viewState.postValue(
            viewModel.viewState.value!!.copy(
                nextIntent = PickCodeIntent.NoIntent
            )
        )

    }

    private fun goToImageFragment(httpCodeIndex: Int) {

        Navigation.findNavController(binding.root)
            .navigate(PickCodeFragmentDirections.pickCodeFragmentToImageFragment(httpCodeIndex))

    }

    override fun onClick(view: View) {

        when (view.id) {

            R.id.informationalButton -> viewModel.onIntent(
                PickCodeIntent.OnClickHttpCodeButton(
                    nextIntent = PickCodeIntent.OnGoToImageFragment(0)
                )
            )

            R.id.successfulButton -> viewModel.onIntent(
                PickCodeIntent.OnClickHttpCodeButton(
                    nextIntent = PickCodeIntent.OnGoToImageFragment(1)
                )
            )

            R.id.redirectionButton -> viewModel.onIntent(
                PickCodeIntent.OnClickHttpCodeButton(
                    nextIntent = PickCodeIntent.OnGoToImageFragment(2)
                )
            )

            R.id.clientErrorButton -> viewModel.onIntent(
                PickCodeIntent.OnClickHttpCodeButton(
                    nextIntent = PickCodeIntent.OnGoToImageFragment(3)
                )
            )

            R.id.serverErrorButton -> viewModel.onIntent(
                PickCodeIntent.OnClickHttpCodeButton(
                    nextIntent = PickCodeIntent.OnGoToImageFragment(4)
                )
            )

        }

    }

}