package com.service.hearstore.ui.heart_list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.service.hearstore.R
import com.service.hearstore.data.model.HeartModel
import com.service.hearstore.databinding.HeartListItemBinding


class HeartLayout: LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    private val binding: HeartListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.heart_list_item, this, false)
    fun loadHeart(heart: HeartModel) {
        binding.apply {
            addView(this.root)
            item=heart
        }
    }
}