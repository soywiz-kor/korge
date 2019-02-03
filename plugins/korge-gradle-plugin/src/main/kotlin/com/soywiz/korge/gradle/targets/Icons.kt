package com.soywiz.korge.gradle.targets

import com.soywiz.korge.gradle.KorgeExtension
import com.soywiz.korge.gradle.KorgeGradlePlugin
import com.soywiz.korge.gradle.util.encodePNG
import com.soywiz.korge.gradle.util.getScaledInstance
import com.soywiz.korge.gradle.util.toBufferedImage
import javax.imageio.ImageIO

val ICON_SIZES = listOf(20, 29, 40, 44, 48, 50, 55, 57, 58, 60, 72, 76, 80, 87, 88, 100, 114, 120, 144, 152, 167, 172, 180, 196, 1024)

fun KorgeExtension.getIconBytes(): ByteArray {
	return when {
		icon?.exists() == true -> icon!!.readBytes()
		else -> KorgeGradlePlugin::class.java.getResource("/icons/korge.png").readBytes()
	}
}

fun KorgeExtension.getIconBytes(size: Int): ByteArray {
	return ImageIO.read(getIconBytes().inputStream()).getScaledInstance(size, size).toBufferedImage().encodePNG()
}

