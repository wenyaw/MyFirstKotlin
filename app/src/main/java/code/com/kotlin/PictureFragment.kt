package code.com.kotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.swipeRefreshLayout

/**
 * Created by ljw on 2018/12/11.
 */

 class PictureFragment : Fragment() {

    companion object {
        fun newInstance() : PictureFragment {
            return PictureFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_pricture,container,false)
        return UI {
            verticalLayout {
                textView {
                    text = "Anko实现列表View"
                    textSize = 16F
                    textColor = Color.parseColor("#333333")
                    gravity = Gravity.CENTER
                }.lparams(matchParent,dip(50)){
                    topMargin = 40
                }
                swipeRefreshLayout {
                    setOnRefreshListener {
                        toast("刷新")
                        isRefreshing = false
                    }
                    recyclerView {
                        layoutManager = LinearLayoutManager(ctx)
                        lparams(matchParent, matchParent)
                        adapter = MyAdapter(ctx, mutableListOf("item1", "item2", "item3", "item4", "item5"))
                    }
                }
            }

        }.view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        val position = arguments!!.get("position")
    }
}