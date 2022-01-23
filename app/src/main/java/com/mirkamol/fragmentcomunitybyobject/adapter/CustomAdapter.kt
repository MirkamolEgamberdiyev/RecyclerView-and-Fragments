package com.mirkamol.fragmentcomunitybyobject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.fragmentcomunitybyobject.R
import com.mirkamol.fragmentcomunitybyobject.model.User

class CustomAdapter(val users: List<User>, private val listener:OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


   inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val number = itemView.findViewById<TextView>(R.id.tv_number)
       val image = itemView.findViewById<AppCompatImageView>(R.id.ic_image)

        init {
            this.itemView.setOnClickListener(this)
        }
        override fun onClick(p0 : View?) {
            listener.clicked(users[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val user = users.get(position)

        if (holder is CustomViewHolder){
            holder.name.setText(user.name)
            holder.number.setText(user.phoneNumber)
            holder.image.setImageResource(user.image)
        }

    }

    override fun getItemCount(): Int {
      return users.size
    }

    interface OnItemClickListener{
        fun clicked(user:User)
    }

}