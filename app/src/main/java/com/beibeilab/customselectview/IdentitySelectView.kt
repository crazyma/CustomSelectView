package com.beibeilab.customselectview

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.LinearLayoutCompat
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View

class IdentitySelectView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr), View.OnClickListener {

    interface OnIdentityItemSelectListener {
        fun onIdentityItemSelected(position: Int)
    }

    private lateinit var cell1: View
    private lateinit var cell2: View
    private lateinit var cell3: View

    var onIdentityItemSelectListener: OnIdentityItemSelectListener? = null

    init {
        orientation = LinearLayoutCompat.VERTICAL
        setupView(context, attrs!!)
    }

    override fun onClick(view: View?) {
        onIdentityItemSelectListener?.apply {
            onIdentityItemSelectListener!!.onIdentityItemSelected(view!!.tag as Int)
        }
    }

    @SuppressLint("InflateParams")
    private fun setupView(context: Context, attrs: AttributeSet) {
        cell1 = LayoutInflater.from(context).inflate(R.layout.layout_identity_item, null)
        cell2 = LayoutInflater.from(context).inflate(R.layout.layout_identity_item, null)
        cell3 = LayoutInflater.from(context).inflate(R.layout.layout_identity_item, null)

        val dp =  getContext().resources.displayMetrics.density

        val lp = LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.MATCH_PARENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT)
        lp.setMargins(0,0,0, (8 * dp).toInt())

        cell1.tag = 0
        cell2.tag = 1
        cell3.tag = 2

        cell1.setOnClickListener(this)
        cell2.setOnClickListener(this)
        cell3.setOnClickListener(this)

        addView(cell1,lp)
        addView(cell2, lp)
        addView(cell3)
    }

}