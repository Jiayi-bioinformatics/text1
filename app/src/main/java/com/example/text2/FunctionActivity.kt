package com.example.text2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.text2.R.*


class FunctionActivity : AppCompatActivity() {
//    建组件对象和属性变量
    private var contentInput: EditText? = null
    private var titleInput: EditText? = null
    private var myBtn1: Button? = null
    private var myBtn2: Button? = null
    private var myBtn3: Button? = null


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_function)

//        找到xml中的对应组件
       val  contentInput = findViewById<View>(id.content_text_input) as EditText
       val titleInput = findViewById<View>(id.title_text_input) as EditText
       val myBtn1 = findViewById<View>(id.btn_1) as Button
        val myBtn2 = findViewById<View>(id.btn_2) as Button
        val myBtn3 = findViewById<View>(id.btn_3) as Button
        var controlTSP = intArrayOf(0,0,0)
          fun validateButton(button: Button,num: Int,editText: EditText){
            button.setOnClickListener {
                if (controlTSP[num] == 0) {
                    controlTSP[num] = 1
                    button.setBackgroundResource(drawable.ic_launcher_background)
                } else {
                    controlTSP[num] = 0
                    button.setBackgroundResource(drawable.bg_username)

                }
//                转型
                var text = contentInput.text.toString()
//                转型
                var spannableString = SpannableString(text)
//                字符串的长度
                var endNumber = spannableString.length-1

//                判断字体类型
                var textStyle = Typeface.NORMAL
                if (controlTSP[2] ==1&& controlTSP[0] ==1)
                    textStyle = Typeface.BOLD_ITALIC
                else if(controlTSP[2] ==1&& controlTSP[0] ==0)
                    textStyle = Typeface.ITALIC
                else if(controlTSP[2] ==0&& controlTSP[0] ==1)textStyle = Typeface.BOLD

//                方案一：保存原字体的字符串，改变EditText的输入字体类型（全体改变），用前者覆盖新文本；
//                方案二：spannableString内进行更改（但没有找到合适的函数调节样式），setSpan前闭后开，start和end都是字符串长度，
//                最后再赋值给EditText的文本；

              }


          }
//激活Buttons切换正文字体
        validateButton(myBtn1,0,contentInput)
        validateButton(myBtn2,1,contentInput)
        validateButton(myBtn3,2,contentInput)

//        实现标题切换字体大小的换行功能
        titleInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // 在文本变化之前的操作
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 在文本变化时的操作
                val lines = titleInput.lineCount
                if (lines > 1) {
                    // 当文本超过一行时，改变字体大小
                    titleInput.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
                } else if (titleInput.length()<15) {
                    // 当文本只有一行时，恢复默认字体大小
                    titleInput.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // 在文本变化之后的操作

            }
        })

//编辑结束后点击”√“可以收起正文的keyboard
        val commitButton = findViewById<Button>(R.id.Commit) as Button

        commitButton.setOnClickListener {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(contentInput.windowToken, 0)
            contentInput.clearFocus()
            titleInput.clearFocus()
        }
// 实现光标选择换字体功能
       /* myBtn1.setOnClickListener {
            val selectionStart = contentInput.selectionStart
            val selectionEnd = contentInput.selectionEnd

            if (selectionStart != -1 && selectionEnd != -1) {
                val selectedText = contentInput.text.substring(selectionStart, selectionEnd)
                val boldText = "<b>$selectedText</b>"
                val styledText = boldText

                val editableText = contentInput.text
                editableText.replace(selectionStart, selectionEnd, styledText)

                contentInput.setText(editableText)
                contentInput.setSelection(selectionStart, selectionStart + styledText.length)
            }
        }

        myBtn1!!.setOnClickListener(View.OnClickListener {
            val inputText: String = contentInput!!.getText().toString()
            val styledText = SpannableString(inputText)
            val start = inputText.length
            // Apply the desired text style to the inputText
                if (currentTypeStyle1 == Typeface.NORMAL) {
                    currentTypeStyle1 = Typeface.BOLD
                } else {
                    currentTypeStyle1 = Typeface.NORMAL
                }


            styledText.setSpan(
                StyleSpan(currentTypeStyle1),
                start,
                inputText.length,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE
            )
            contentInput!!.setText(styledText)
        })
*/



    }



}


