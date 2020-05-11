package udit.programmer.co.lec9_code1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itemview.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    var data: List<Users> = ArrayList()
    var onItemClick: ((login: String) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val item_view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemview, parent, false)
        return UserViewHolder(item_view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.name_view.text = data[position].type
        holder.itemView.login_view.text = data[position].login
        Picasso.get().load(data[position].avatarUrl).into(holder.itemView.image_view)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(data[position].login!!)
        }
    }

    fun swapData(data: List<Users>) {
        this.data = data
        notifyDataSetChanged()
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}

