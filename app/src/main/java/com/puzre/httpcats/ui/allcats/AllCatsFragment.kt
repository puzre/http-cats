package com.puzre.httpcats.ui.allcats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puzre.httpcats.databinding.FragmentAllCatsBinding

class AllCatsFragment : Fragment() {

    private var _binding: FragmentAllCatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAllCatsBinding.inflate(inflater, container, false)

        return binding.root

    }

}