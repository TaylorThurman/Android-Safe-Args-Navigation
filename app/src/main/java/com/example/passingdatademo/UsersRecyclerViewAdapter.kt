package com.example.passingdatademo

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController

import com.example.passingdatademo.dummy.DummyContent.DummyItem

class UsersRecyclerViewAdapter(
    private val users: List<User>
) : RecyclerView.Adapter<UsersRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_users, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.idView.text = user.id.toString()
        holder.contentView.text = user.name
        holder.user = user
    }

    override fun getItemCount(): Int = users.size

    inner class ViewHolder(view: View, var user: User? = null) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)

        init {
            view.setOnClickListener {
                user?.let {
                    val directions = UsersFragmentDirections.actionUsersFragmentToUserDetailsFragment(it)
                    view.findNavController().navigate(directions)
                }
            }
        }

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}