package com.example.android.navdrawertest.home_activity.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.data.models.ProfileData
import com.example.android.navdrawertest.commons.BaseFragment
import com.example.android.navdrawertest.commons.emptyString
import com.example.android.navdrawertest.databinding.FragmentProfileBinding
import com.example.android.navdrawertest.home_activity.profile.vm.ProfileViewModel
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
        presenter.profileData.observe(viewLifecycleOwner, {
            it?.apply {
                binding.tvName.text = "Name: $name"
                binding.tvSurnameOne.text = "Surname One: $surnameOne"
                binding.tvSurnameTwo.text = "Surname Two: $surnameTwo"
                binding.tvPostalAddress.text = "Postal Address: $postalAddress"
            }

        })
    }

    override fun loadListeners() {
        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString().emptyString()
            val surnameOne = binding.etSurnameOne.text.toString().emptyString()
            val surnameTwo = binding.etSurnameTwo.text.toString().emptyString()
            val postalAddress = binding.etPostalAdress.text.toString().emptyString()
            presenter.saveProfileData(ProfileData(1, name, surnameOne, surnameTwo, postalAddress))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}