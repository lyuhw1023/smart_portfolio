package kr.ac.hallym.smartportfolio

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.smartportfolio.databinding.CardLayoutBinding

class ProjectViewHolder(val binding: CardLayoutBinding): RecyclerView.ViewHolder(binding.root)

class ProjectAdapter (val contents1: MutableList<String>?, val contents2: MutableList<Int>?,
                        val contents3: MutableList<String>?): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ProjectViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ProjectViewHolder).binding
        binding.titleText.text = contents1!![position]
        binding.imageView.setImageResource(contents2!![position])
        binding.detailText.text = contents3!![position]

    }

    override fun getItemCount(): Int {
        return contents1?.size ?: 0
    }
}