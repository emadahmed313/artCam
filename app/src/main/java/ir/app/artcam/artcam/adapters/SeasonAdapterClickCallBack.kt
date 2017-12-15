package ir.app.artcam.artcam.adapters

import ir.app.artcam.artcam.models.Part

/**
 * Created by saeed on 12/14/17.
 */
interface SeasonAdapterClickCallBack {

    fun onPartItemClicked(pos: Int, part: Part)

}