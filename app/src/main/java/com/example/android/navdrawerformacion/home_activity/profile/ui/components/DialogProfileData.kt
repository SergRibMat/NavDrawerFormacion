package com.example.android.navdrawerformacion.home_activity.profile.ui.components

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import com.example.android.data.models.ProfileData
import com.example.android.navdrawerformacion.commons.emptyString
import com.example.android.navdrawerformacion.databinding.DialogProfileDataBinding
import com.example.android.navdrawerformacion.home_activity.profile.vm.ProfileViewModel

class DialogProfileData(context: Context, private val presenter: ProfileViewModel): Dialog(context) {

    private lateinit var binding: DialogProfileDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DialogProfileDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadListeners()
    }

    override fun show() {
        super.show()
        val window = window
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }


    fun loadListeners(){
        binding.btnSave.setOnClickListener {
            //get text from EditTexts
            val name = binding.etName.text.toString().emptyString()
            val surnameOne = binding.etSurnameOne.text.toString().emptyString()
            val surnameTwo = binding.etSurnameTwo.text.toString().emptyString()
            val postalAddress = binding.etPostalAdress.text.toString().emptyString()
            //create object with EditText text
            val profileData = ProfileData(1, name, surnameOne, surnameTwo, postalAddress)
            //give object to viewmodel
            presenter.saveProfileData(profileData)
            dismiss()
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }

}