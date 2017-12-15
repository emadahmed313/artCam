package ir.app.artcam.artcam.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ir.app.artcam.artcam.R
import ir.app.artcam.artcam.models.MainItem
import ir.app.artcam.artcam.models.Part
import ir.app.artcam.artcam.utils.GlideApp


class SeasonAdapter(private val context: Context, private val seasonAdapterClickCallBack: SeasonAdapterClickCallBack, val mainItem: MainItem) : RecyclerView.Adapter<SeasonAdapter.SeasonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SeasonViewHolder {

        return SeasonViewHolder(seasonAdapterClickCallBack, LayoutInflater.from(context).inflate(R.layout.season_recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {

        holder.bindView(mainItem.parts.get(position))

    }

    override fun getItemCount(): Int {

        return mainItem.parts.size

    }

    class SeasonViewHolder(val seasonAdapterClickCallBack: SeasonAdapterClickCallBack, val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {


        val title: TextView = view.findViewById(R.id.textView_parts_title)
        val image: ImageView = view.findViewById(R.id.imageView_parts_image)
        lateinit var part: Part

        fun bindView(part: Part) {

            this.part = part
            view.setOnClickListener(this)
            title.text = part.title

            GlideApp.with(view).load(part.resID)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .into(image)


        }

        override fun onClick(p0: View?) {
            seasonAdapterClickCallBack.onPartItemClicked(adapterPosition, part)
        }


    }
}