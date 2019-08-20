package pers.peng.ui.interswitch

import android.view.View
import androidx.viewpager.widget.ViewPager

class GalleryTransformer:ViewPager.PageTransformer {
    val MAX_ALPHA:Float=0.5f
    val MAX_SCALE:Float=0.9f
    override fun transformPage(page: View, position: Float) {
       if(position<-1||position>1){
           page.alpha=MAX_ALPHA
           page.scaleX=MAX_SCALE
           page.scaleY=MAX_SCALE
       }else{
           if(position<=0){
               page.alpha=MAX_ALPHA+MAX_ALPHA*(1+position)
           }else{
               page.alpha=MAX_ALPHA+MAX_ALPHA*(1-position)
           }
           val scale=Math.max(MAX_SCALE,1-Math.abs(position))
           page.scaleX=scale
           page.scaleY=scale
       }
    }
}