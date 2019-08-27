package pers.peng.ui.interswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TabLayoutActivity : AppCompatActivity() {
    private lateinit var mViewPager: ViewPager
    private lateinit var mTabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        mViewPager=findViewById(R.id.viewpager)
        mTabLayout=findViewById(R.id.tabs)
        initViewPager()
    }
    private fun initViewPager(){
        val titles:MutableList<String> =ArrayList()
        titles.add("fragment1")
        titles.add("fragment2")
        titles.add("fragment3")
        for(i in 0 until titles.size){
            mTabLayout.addTab(mTabLayout.newTab().setText(titles[i]))}
        val fragments:MutableList<Fragment> =ArrayList()
        fragments.add(Fragment1())
        fragments.add(Fragment2())
        fragments.add(Fragment3())
        mViewPager.adapter=object : FragmentStatePagerAdapter(supportFragmentManager){
            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }

            override fun getCount(): Int {
                return fragments.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return titles[position]
            }
        }
        mTabLayout.setupWithViewPager(mViewPager,true)

    }
}
