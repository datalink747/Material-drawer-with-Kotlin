package material_design.soussi.com.material_drawer

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.squareup.picasso.Picasso

import java.util.ArrayList

import material_design.soussi.com.material_drawer.model.Events

/**
 * Created by Soussi on 06/11/2015.
 */
class RecyclerViewAdapter(internal var callback: RecyclerViewAdapter.RecyclerViewAdapterCallBack) : RecyclerView.Adapter<RecyclerViewAdapter.ContentViewHolder>() {

    interface RecyclerViewAdapterCallBack {
        fun onRecyclerViewElementClicked(view: View, position: Int, element: Events)
    }

    internal var contents: MutableList<Events> = ArrayList()

    fun addObjects(contents: List<Events>) {
        this.contents.addAll(contents)
        super.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return contents.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.cell_cards, parent, false)
        return ContentViewHolder(view, callback)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(contents[position])
    }

    inner class ContentViewHolder
    //@InjectView(R.id.text)

    //@InjectView(R.id.image)


    (itemView: View, private val callback: RecyclerViewAdapterCallBack) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var myObject: Events? = null
        private val textViewView: TextView
        private val imageView: ImageView

        init {

            // ButterKnife.inject(this, itemView);
            textViewView = itemView.findViewById(R.id.text) as TextView
            imageView = itemView.findViewById(R.id.image) as ImageView
            this.itemView.setOnClickListener(this)
        }

        fun bind(myObject: Events) {
            this.myObject = myObject
            textViewView.text = myObject.text
            Picasso.with(imageView.context).load(myObject.imageUrl).centerCrop().fit().into(imageView)
        }

        override fun onClick(v: View) {
            this.callback.onRecyclerViewElementClicked(this.itemView, this.adapterPosition, myObject!!)
        }
    }
}