package com.nc.mangalfare.fragments

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.nc.mangalfare.R
import com.nc.mangalfare.customviews.CustomShagunProgressBar

class BaseFragments(@LayoutRes layout: Int) : Fragment(layout) {
    val progessDialog by lazy {
        CustomShagunProgressBar(requireContext())
    }

    protected fun getController(): NavController {
        return requireActivity().findNavController(R.id.nav_host_fragment)
    }

}