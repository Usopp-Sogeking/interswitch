package pers.peng.ui.interswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class TabLayoutActivity : AppCompatActivity() {
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var mViewPager: ViewPager
    private lateinit var mTabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val ab=supportActionBar
        ab?.setHomeAsUpIndicator(R.drawable.ic_menu)
        ab?.setDisplayHomeAsUpEnabled(true)
        mViewPager=findViewById(R.id.viewpager)
        mTabLayout=findViewById(R.id.tabs)
        mDrawerLayout=findViewById(R.id.dl_main_drawer)
        val navigationView: NavigationView =findViewById(R.id.nv_main_navigation)
        if(navigationView!=null){
            navigationView.setNavigationItemSelectedListener {
                it.isChecked = true
                when(it.itemId){
                    R.id.nav_first->mViewPager.currentItem=0
                    R.id.nav_second->mViewPager.currentItem=1
                    R.id.nav_three->mViewPager.currentItem=2
                }
                mDrawerLayout.closeDrawers()
                true
            }
        }
        initViewPager()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                mDrawerLayout.openDrawer(GravityCompat.START)
                return true}
        }
        return super.onOptionsItemSelected(item)
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
