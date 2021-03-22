package com.example.android.navdrawertest.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.navdrawertest.R

class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        detailViewModel =
                ViewModelProvider(this).get(DetailViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_detail, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        detailViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}