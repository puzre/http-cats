package com.puzre.httpcats.ui.image

import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.puzre.httpcats.R
import com.puzre.httpcats.databinding.FragmentImageBinding

class ImageFragment : Fragment(), View.OnClickListener {

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

        binding.reloadImageButton.setOnClickListener(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, Observer {

            showLoading(it.isLoading)
            binding.view.isVisible = !it.isLoading

            when(it.nextIntent){

                is ImageIntent.OnGetRandomHttpCode -> viewModel.onIntent(ImageIntent.OnGetRandomHttpCode)
                is ImageIntent.OnCreateUrlImage -> viewModel.onIntent(ImageIntent.OnCreateUrlImage)
                is ImageIntent.OnLoadImage -> loadImage(it.nextIntent.urlImage)
                else -> {}

            }

        })

        viewModel.onIntent(ImageIntent.OnSaveHttpCodeIndex(httpCodeIndex!!))

    }

    private fun loadImage(urlImage: String) {

        Glide.with(this@ImageFragment).load(urlImage).into(object: CustomTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {

                binding.imageViewHttpCodeImage.setImageDrawable(resource)

                viewModel.onIntent(ImageIntent.LoadImageSuccess)

            }

            override fun onLoadCleared(placeholder: Drawable?) {}

        })

    }

    private fun showLoading(isVisible: Boolean){

        if(requireContext().resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES)
            binding.darkLoading.isVisible = isVisible
        else
            binding.lightLoading.isVisible = isVisible

    }

    override fun onClick(view: View) {

        when(view.id){

            R.id.reloadImageButton -> viewModel.onIntent(ImageIntent.OnReloadImage)

        }

    }

}