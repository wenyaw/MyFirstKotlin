package code.com.kotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.frag_my_tab.*

/**
 * Created by ljw on 2018/12/7.
 */

 class MyTabFragment : Fragment() {

    companion object {
        fun newInstance() : MyTabFragment{
            return MyTabFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_my_tab,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val position = arguments!!.get("position")
        tv_title.text = "Content: " + position
    }
}