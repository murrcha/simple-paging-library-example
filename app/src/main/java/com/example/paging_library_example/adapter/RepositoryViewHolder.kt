package com.example.paging_library_example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.paging_library_example.R
import com.example.paging_library_example.api.Repository

/**
 * @author Ksenya Kaysheva (murrcha@me.com)
 * @since june 2019
 */
class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val name = view.findViewById<TextView>(R.id.name)
    private val fullName = view.findViewById<TextView>(R.id.fullName)
    private val description = view.findViewById<TextView>(R.id.description)
    private val url = view.findViewById<TextView>(R.id.url)

    fun bind(repository: Repository?) {
        if (repository == null) {
            name.text = UNKNOWN
            fullName.text = UNKNOWN
            description.text = UNKNOWN
            url.text = UNKNOWN
        } else {
            name.text = repository.name
            fullName.text = repository.fullName
            description.text = repository.description ?: UNKNOWN
            url.text = repository.url
        }
    }

    companion object {
        private const val UNKNOWN = "Unknown"

        fun create(parent: ViewGroup): RepositoryViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.repository_item, parent, false)
            return RepositoryViewHolder(view)
        }
    }
}
