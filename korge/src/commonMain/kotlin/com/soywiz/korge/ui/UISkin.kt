package com.soywiz.korge.ui

import com.soywiz.korge.view.*
import com.soywiz.korim.bitmap.*
import com.soywiz.korim.color.*

data class UISkin(
    val normal: BmpSlice,
    val hover: BmpSlice = normal,
    val down: BmpSlice = normal,
    val disabled: BmpSlice = normal,
    val backColor: RGBA = Colors.DARKGREY
)

val DefaultUISkin by lazy {
    UISkin(
        normal = DEFAULT_UI_SKIN_IMG.sliceWithSize(0, 0, 64, 64),
        hover = DEFAULT_UI_SKIN_IMG.sliceWithSize(64, 0, 64, 64),
        down = DEFAULT_UI_SKIN_IMG.sliceWithSize(128, 0, 64, 64),
        disabled = DEFAULT_UI_SKIN_IMG.sliceWithSize(192, 0, 64, 64)
    )
}

var View.defaultUISkin: UISkin by defaultElement(DefaultUISkin)
