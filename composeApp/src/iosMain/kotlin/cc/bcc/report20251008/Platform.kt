package cc.bcc.report20251008

import platform.UIKit.UIDevice

class IOSPlatform {
    val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

fun getPlatform() = IOSPlatform()