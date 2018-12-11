package code.com.kotlin

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_test.text = "My First Kotlin!"
//        File("a.text").let{
//            it.absoluteFile  //let把file对象赋给了it
//        }
        val mRecyclerView = recyclerview
//        mRecyclerView.layoutManager = LinearLayout(this)

    }

    fun setData(){
        var person = Person("Lj","123")
        Toast.makeText(this,person.name, Toast.LENGTH_SHORT).show()
    }

    fun checkNull(message: Any?) {
        Toast.makeText(this,message?.toString(),Toast.LENGTH_SHORT).show()
         }

    fun createDialog(){
//        val dialog = Dialog(this, R.style.DialogNoTitle)
//         dialog.setContentView(this.linearLayout {
//                 imageView {
//                         Utils.setImageToView(mContext, null, imageUri, this)
//                         onClick {
//                                 dialog.dismiss()
//                             }
//                     }
//             })
//
//         dialog.show()
    }

    override fun onClick(view : View){
        val id = view.id
        when(id){
            R.id.tv_test -> setData()
            R.id.btn_check_null -> checkNull("hello")
        }
    }
}
