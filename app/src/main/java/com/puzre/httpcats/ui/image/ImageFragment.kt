package com.puzre.httpcats.ui.image

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.puzre.httpcats.databinding.FragmentImageBinding

class ImageFragment : Fragment(), ImageViewEvents {

    private val viewModel: ImageViewModel by viewModels()

    private val args: ImageFragmentArgs by navArgs()
    private var httpCodeIndex: Int? = null

    private var _binding: FragmentImageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        httpCodeIndex = args.httpCodeIndex

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentImageBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.viewEvents = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, Observer {

            when (it.nextIntent) {

                is ImageIntent.OnGetHttpCatListByIndex -> viewModel.onIntent(ImageIntent.OnGetHttpCatListByIndex)
                is ImageIntent.OnGetRandomHttpCat -> viewModel.onIntent(ImageIntent.OnGetRandomHttpCat)
                else -> {}

            }

        })

        viewModel.onIntent(ImageIntent.OnViewCreated(httpCodeIndex))

    }

    override fun onClickReload(view: View) {
        viewModel.onIntent(ImageIntent.OnGetRandomHttpCat)
    }

}