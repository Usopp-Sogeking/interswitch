package pers.peng.ui.interswitch

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class fragment2:Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment2,container,false)
        return view
    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d("fragment2","onAttach")
    }
    override fun onPause() {
        super.onPause()
        Log.d("fragment2","onPause")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("fragment2","onActivityCreate")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("fragment2","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("fragment2","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("fragment2","onResume")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("fragment2","onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("fragment2","onDestroyView")
    }

    override fun onStop() {
        super.onStop()
        Log.d("fragment2","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("fragment2","onDestroy")
    }
}