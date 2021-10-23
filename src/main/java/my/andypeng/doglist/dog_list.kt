package my.andypeng.doglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class dogclass constructor(val dog_name:String ,val slogan:String, val dog_id:Int,val dog_age:Int){

}

class dog_view_holder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    var name  = itemView.findViewById<TextView>(R.id.name_menu)
    var image = itemView.findViewById<ImageView>(R.id.image_menu)


}

class dog_adapter(var items:ArrayList<dogclass>) : RecyclerView.Adapter<dog_view_holder>() {


    var listener: OnItemClickListener? = null

    interface OnItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClick(listener: OnItemClickListener?) {
        this.listener = listener
    }


    //  创建 ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dog_view_holder {

        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return dog_view_holder(view)
    }

    //  更新 ViewHolder
    override fun onBindViewHolder(holder: dog_view_holder, position: Int) {
        holder.name?.text = items[position].dog_name
        holder.image?.setImageResource(items[position].dog_id)

        holder.itemView.setOnClickListener{
            listener?.onItemClick(position)
        }

    }

    //  控制列表项个数
    override fun getItemCount(): Int {
        return items.size
    }

    fun updateItems(items: List<dogclass>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

}