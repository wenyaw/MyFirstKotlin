package code.com.kotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.InputType
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.UI

/**
 * Created by ljw on 2018/12/11.
 */

 class FmFragment : Fragment() {

    companion object {
        fun newInstance() : FmFragment {
            return FmFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI{
            var et_username : EditText? = null
            var et_password : EditText? = null
            verticalLayout {
                leftPadding = dip(15)
                rightPadding = dip(15)
                lparams(matchParent, matchParent)
                textView {
                    textSize = 18f
                    textColor = Color.parseColor("#333333")
                    text = "Anko 实现登录View"
                    gravity = Gravity.CENTER
                }.lparams(matchParent, dip(40)) {
                    topMargin = dip(30)
                }

                et_username = editText {
                    hint = "请输入用户名"
                    textColor = Color.parseColor("#666666")
                    textSize = 15f
                    leftPadding = dip(8)
                    gravity = Gravity.LEFT
                }.lparams(matchParent, dip(40)) {
                    topMargin = dip(30)
                }
                et_password = editText {
                    hint = "请输入密码"
                    textColor = Color.parseColor("#666666")
                    textSize = 15f
                    leftPadding = dip(8)
                    inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                    gravity = Gravity.LEFT
                }.lparams(matchParent, dip(40)) {
                    topMargin = dip(10)
                }
                button {
                    textSize = 16f
                    textColor = Color.parseColor("#FFFFFF")
                    backgroundColor = Color.parseColor("#438AFF")
                    text = "登录"
                    gravity = Gravity.CENTER
                    top = 30
                    left = 20
                    right = 30
                    alpha = 0.5f
                    onClick {
                        var username = et_username!!.text.toString()
                        var password = et_password!!.text.toString()
                        toast("用户名：" + username + ",密码： " + password)
                    }
                }.lparams(matchParent, dip(40)) {
                    topMargin = dip(20)
                }
            }
        }.view
//        return inflater.inflate(R.layout.fragment_fm,container,false)
    }

}