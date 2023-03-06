package com.lnight.bluetoothchat.presentation.device_screen

import com.lnight.bluetoothchat.domain.chat.BluetoothDeviceDomain

data class BluetoothDeviceState(
    val scannedDevices: List<BluetoothDeviceDomain> = emptyList(),
    val pairedDevices: List<BluetoothDeviceDomain> = emptyList(),
    val isConnected: Boolean = false,
    val isConnecting: Boolean = false,
    val errorMessage: String? = null
)