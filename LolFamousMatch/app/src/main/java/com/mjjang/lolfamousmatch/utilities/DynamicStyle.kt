package com.mjjang.lolfamousmatch.utilities

import android.content.res.ColorStateList
import com.google.android.material.chip.Chip
import com.mjjang.lolfamousmatch.R
import com.mjjang.lolfamousmatch.manager.App

object DynamicStyle {

    fun setChipStyle(view: Chip) {
        view.setChipBackgroundColorResource(R.color.white)
        view.setChipStrokeColorResource(R.color.gray)
        view.setChipStrokeWidthResource(R.dimen.chip_stroke_width)
    }

    fun setChipFilterStyle(view: Chip) {
        view.isCheckable = true
        view.isChipIconVisible = false
        view.isCloseIconVisible = false
        view.checkedIcon = null
        view.chipBackgroundColor = view.resources.getColorStateList(R.color.filter_chip_backgound_color_selector, null)
    }
}