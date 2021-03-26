package com.example.android.navdrawertest.home_activity.home.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.data.models.PokemonDTO
import com.example.android.navdrawertest.commons.fromTypesListToString
import com.example.android.navdrawertest.commons.printImageWithGlide
import com.example.android.navdrawertest.databinding.ItemPokemonBinding

class AdapterPokemonGrid(private var mValues: List<PokemonDTO>?,
                         private val cellClickListener: CellClickListener,
                         private val context: Context
) : RecyclerView.Adapter<AdapterPokemonGrid.ViewHolder>() {

    private lateinit var binding: ItemPokemonBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    //sets value to view objects
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mValues?.let {
            holder.tvName.text = "Name:\n${it[position].name}"

            val types = fromTypesListToString(it[position].types)
            holder.tvSpecie.text = "Type:$types"

            holder.tvWeight.text = "${it[position].weight} KG"

            printImageWithGlide(context, it[position].image.image, holder.ivImage)

            holder.itemView.setOnClickListener { _ ->
                cellClickListener.onCellClickListener(it[position])
            }
        } ?: clearList()
    }

    override fun getItemCount(): Int {
        return mValues?.size ?: 0
    }

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val tvName = binding.tvName
        val tvSpecie = binding.tvSpecie
        val tvWeight = binding.tvWeight
        val ivImage = binding.ivImage
    }

    private fun clearList() {
        val emptyList = listOf<PokemonDTO>()
        mValues = emptyList
        notifyItemRangeRemoved(0, 0)
    }
}

interface CellClickListener {
    fun onCellClickListener(pokemon: PokemonDTO)
}