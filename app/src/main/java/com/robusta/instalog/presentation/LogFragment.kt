package com.robusta.instalog.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.robusta.instalog.databinding.FragmentLogBinding
import com.robusta.instalog.utils.queryUserLocation
import com.robusta.instalog.utils.requestLocationPermission
import com.robusta.instalog.utils.showPermissionDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LogFragment : Fragment() {

    private lateinit var binding : FragmentLogBinding
    private lateinit var locationPermissionRequestLauncher: ActivityResultLauncher<String>
    private val viewModel : LogViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogBinding.inflate(inflater, container, false)

        locationPermissionRequestLauncher = requestLocationPermission(locationResultBlock)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findUserLocation()
        lifecycleScope.launch{
            viewModel.currentWeather.collect{
                Log.d("WEATHER", it?.temp?.temp.toString())
            }
        }
//        setupViews()
//        setupMenu()
//        observeData(vm, binding.errorView)
//        setupBackPressedBehavior()
    }

    private val locationResultBlock = { isGranted: Boolean ->
        if (isGranted) {
            queryUserLocation(
                onSuccess = {
                    viewModel.getCurrentWeatherData(lat = it?.latitude.toString(), lng = it?.longitude.toString())
                },
                onError = {
                        Log.d("ERROR",it?.message.toString())
                }
            )
        } else {
            showPermissionDialog()
        }
    }
    private fun findUserLocation() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            locationPermissionRequestLauncher.launch(
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        } else {
            queryUserLocation(
                onSuccess = {
                    viewModel.getCurrentWeatherData(lat = it?.latitude.toString(), lng = it?.longitude.toString())
                },
                onError = {
                    Log.d("ERROR",it?.message.toString())
                }
            )
        }
    }
}