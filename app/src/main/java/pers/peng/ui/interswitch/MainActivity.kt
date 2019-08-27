package pers.peng.ui.interswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mButton1:Button
    private lateinit var mButton2:Button
    private lateinit var mButton3:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mButton1=findViewById(R.id.fragment1_btn)
        mButton2=findViewById(R.id.fragment2_btn)
        mButton3=findViewById(R.id.fragment3_btn)
        mButton1.setOnClickListener(this)
        mButton2.setOnClickListener(this)
        mButton3.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.fragment1_btn->replaceFragment(Fragment1())
            R.id.fragment2_btn->replaceFragment(Fragment2())
            R.id.fragment3_btn->replaceFragment(Fragment3())
        }
    }
    fun replaceFragment(fragment:Fragment){
        val fm=supportFragmentManager
        val ft=fm.beginTransaction()
        ft.replace(R.id.framelayout,fragment)
        ft.commit()
    }
}
