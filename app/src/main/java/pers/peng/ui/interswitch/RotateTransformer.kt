package pers.peng.ui.interswitch

import android.util.Log
import android.view.View
import androidx.viewpager.widget.ViewPager

class RotateTransformer:ViewPager.PageTransformer {
    val mOffset=60
    override fun transformPage(page: View, position: Float) {
        if(position<0){
            Log.d("rotatetransformer", "if $position")
            page.translationX=0f
            page.rotation=45*position
            page.translationX=page.width/2*position
        }else{
            Log.d("rotatetransformer", "else $position")
            page.translationX=-position*page.width
            val scale=(page.width-mOffset*position)/page.width
            page.scaleX=scale
            page.scaleY=scale
            page.translationY=position*mOffset
        }
    }
}