package code.com.kotlin

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import code.com.kotlin.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.layout_my_tab.*
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.verticalLayout
import widget.SlidingTabLayout

/**
 * Created by ljw on 2018/12/7.
 */
class MyTabAct : AppCompatActivity() , OnTabSelectListener {

    private var mTablayout : SlidingTabLayout ?= null
    private var mViewpager : ViewPager ?= null

    val mTabTitle : ArrayList<String> = arrayListOf("TAB1","TAB2","TAB3","TAB4")
    val mFragmentList = arrayOfNulls<Fragment>(4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_my_tab)
        mTablayout = my_sliding_tab
        mViewpager = my_viewpager
        addFragment()
    }

    /**
     * 添加fragment
     */
    fun addFragment(){
        var mPageFragment = MyPagerAdapter(supportFragmentManager)
//        if (mFragmentList == null){
            mFragmentList.set(0,FmFragment.newInstance())
            mFragmentList.set(1,PictureFragment.newInstance())
            mFragmentList.set(2,TemplateFragment.newInstance())
            mFragmentList.set(3,MyTabFragment.newInstance())
//        }
        mViewpager!!.adapter= mPageFragment
        mTablayout!!.setViewPager(mViewpager)
        mTablayout!!.setOnTabSelectListener(this)

    }

    private inner class MyPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm){

        override fun getItem(p0: Int): Fragment? {
//            val fragment = MyTabFragment.newInstance()
//            val bundle = Bundle()
//            bundle.putString("position",mTabTitle[p0])
//            fragment.arguments = bundle
            return mFragmentList.get(p0)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mTabTitle[position]
        }

        override fun getCount(): Int {
            return mTabTitle.size
        }

    }

    override fun onTabSelect(position: Int) {
        mTablayout!!.currentTab= position
    }

    override fun onTabReselect(position: Int) {

    }

}