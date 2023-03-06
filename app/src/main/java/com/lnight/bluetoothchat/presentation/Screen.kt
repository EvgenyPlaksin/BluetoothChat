package com.lnight.bluetoothchat.presentation

sealed class Screen(val route: String) {
    object DeviceScreen : Screen("device_screen")
}