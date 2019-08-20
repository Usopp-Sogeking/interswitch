package pers.peng.ui.interswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager

class ViewPagerActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var mButton1: Button
    private lateinit var mButton2: Button
    private lateinit var mButton3: Button
    private lateinit var mViewPager:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        mButton1=findViewById(R.id.fragment1_btn)
        mButton2=findViewById(R.id.fragment2_btn)
        mButton3=findViewById(R.id.fragment3_btn)
        val fragmentList:List<Fragment> = listOf(fragment1(),fragment2(),fragment3())
        mViewPager=findViewById(R.id.viewPager)
        val fm=supportFragmentManager
        mViewPager.offscreenPageLimit=3
       // mViewPager.setPageTransformer(true,GalleryTransformer())
        mViewPager.setPageTransformer(true,RotateTransformer())
        mViewPager.pageMargin=40
        mViewPager.adapter=object :FragmentStatePagerAdapter(fm){
            override fun getItem(position: Int): Fragment {
                return fragmentList[position]
            }

            override fun getCount(): Int {
                return fragmentList.size
            }
        }
        mButton1.setOnClickListener(this)
        mButton2.setOnClickListener(this)
        mButton3.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.fragment1_btn->mViewPager.currentItem=0
            R.id.fragment2_btn->mViewPager.currentItem=1
            R.id.fragment3_btn->mViewPager.currentItem=2
        }
    }
}

