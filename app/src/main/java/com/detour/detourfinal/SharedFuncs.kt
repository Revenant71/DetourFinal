package com.detour.detourfinal

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment

object SharedFuncs {

    fun goActivity(context: Context, newActivity:Class<*>){
        val newIntent = Intent(context, newActivity);
        context.startActivity(newIntent);

        if (context is Activity) {
            context.finish()
        }
    }

    fun goFragment(activity: AppCompatActivity, containerId: Int, newFragment: Fragment) {
        val transaction = activity.supportFragmentManager.beginTransaction()

        transaction.replace(containerId, newFragment)

        transaction.commit()
    }

    // TODO
    //
    //
    //
    //


}