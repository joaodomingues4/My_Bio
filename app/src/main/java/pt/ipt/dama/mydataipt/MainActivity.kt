package pt.ipt.dama.mydataipt

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // override para herdar
        super.onCreate(savedInstanceState) // super para fazer as coisas do onCreate
        setContentView(R.layout.activity_main)

        // find the button, and add some action
        findViewById<Button>(R.id.nicknameButton).setOnClickListener {// setOnClickListener para ficar À escuta da atividade acima
            addNickname(it) // aqui o "it" faz com que se leia o que foi escrito
        }
    }


    /**
     * read the nickname and write it to screen and show the users' CV
     */
    private fun addNickname(view: View) {
    //write here what the button will do...


    // find the elements that i want to change
    // we are making 'pointers' to that elements
        val auxNicknameTextBox=findViewById<EditText>(R.id.nicknameEditText)
        val auxNicknameTextView=findViewById<TextView>(R.id.showNicknameTextView)
        val auxButtonNickname = findViewById<Button>(R.id.nicknameButton)
        val auxUsersCV_TextView = findViewById<TextView>(R.id.usersCV_TextView)

    // assign the text from TextBox to TextView
        auxNicknameTextView.text = auxNicknameTextBox.text

    // show the TextViews, and hide the button
    // other elements that i don't need anymore
        auxNicknameTextView.visibility = View.VISIBLE
        auxUsersCV_TextView.visibility = View.VISIBLE
        auxNicknameTextBox.visibility = View.GONE
        auxButtonNickname.visibility = View.GONE

    // esconder o teclado
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}