package com.beibeilab.customselectview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),IdentitySelectView.OnIdentityItemSelectListener {

//    private lateinit var identitySelectView: IdentitySelectView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = "XD`"

//        identitySelectView = findViewById(R.id.identitySelectView)

        if(identitySelectView == null){
            Log.d("crazyma","NULL NULL NULL NULL ")
        }else{
            Log.d("crazyma","NNNNNNNNNNNNNNNNNNN")
        }

        identitySelectView.onIdentityItemSelectListener = this

        button.setOnClickListener{
            Log.i("crazyma","button click")
        }
    }

    override fun onIdentityItemSelected(position: Int) {
        Log.d("crazyma","position $position")
    }
}
