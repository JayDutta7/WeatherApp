package com.home.weatherapp.utility.validation

import android.text.TextUtils
import android.util.Patterns
import androidx.appcompat.widget.AppCompatEditText
import java.util.regex.Pattern

object Validation {


        /*Pattern--Keyboard*/
        private const val PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,12})"

        //-----------------------Email Validation-----------------------------
        fun isEmailValid(email: CharSequence): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        /*-----------------------Edittext validation checking--------------------*/
        fun isEditTextEmpty(view: AppCompatEditText?, msg: CharSequence?):Boolean {
            if (TextUtils.isEmpty(view!!.text.toString())) {
                view.error = msg
                view.requestFocus()
                return false
            }
            return true
        }

        /*-----------------------Password validation checking---------------------*/
        fun isPasswordValid(msg: CharSequence?):Boolean{
            return Pattern.compile(PASSWORD_PATTERN).matcher(msg).matches()
        }



}