package com.learn.app

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learn.app.databinding.ItemUserBinding
import com.learn.app.models.User


class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    var users: List<User> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun getItemCount():
            Int = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val inflater = LayoutInflater.from(parent.context) // связывает
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = users[position]

        holder.binding.userCompanyTextView.text = user.name

        with(holder.binding) {
            userNameTextView.text = user.name
            userCompanyTextView.text = user.company

            if (user.photo.isNotBlank()) {
                Glide.with(photoImageView.context)
                    .load(user.photo)
                    .circleCrop()
                    .placeholder(R.drawable.ic_user_avatar)
                    .error(R.drawable.ic_user_avatar)
                    .into(photoImageView)
            } else {
                Glide.with(photoImageView.context)
                    .load(R.drawable.ic_user_avatar)
                    .into(photoImageView)
            }
        }
    }

    class UsersViewHolder(
        val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root)
}