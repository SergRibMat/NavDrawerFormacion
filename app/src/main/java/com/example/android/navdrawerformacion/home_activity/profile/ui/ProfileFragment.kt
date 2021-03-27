package com.example.android.navdrawerformacion.home_activity.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.navdrawerformacion.R
import com.example.android.navdrawerformacion.commons.BaseFragment
import com.example.android.navdrawerformacion.databinding.FragmentProfileBinding
import com.example.android.navdrawerformacion.home_activity.profile.ui.components.DialogProfileData
import com.example.android.navdrawerformacion.home_activity.profile.vm.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment() {

    private val presenter: ProfileViewModel by viewModel()


    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun loadObservers() {
        //update view on change
        presenter.profileData.observe(viewLifecycleOwner, {
            it?.apply {
                //update view with it data
                binding.tvName.text = "${getString(R.string.textview_name)} $name"
                binding.tvSurnameOne.text = "${getString(R.string.textview_surname_one)} $surnameOne"
                binding.tvSurnameTwo.text = "${getString(R.string.textview_surname_two)} $surnameTwo"
                binding.tvPostalAddress.text = "${getString(R.string.textview_postal_address)} $postalAddress"
            }
        })
    }


    override fun loadListeners() {
        binding.btnShowDialogProfileData.setOnClickListener {
            //create dialog object
            val dialogProfileData = activity?.let { activity ->
                DialogProfileData(
                        activity,
                        presenter
                )
            }
            dialogProfileData!!.setCancelable(false)
            dialogProfileData!!.show()
        }
    }
}