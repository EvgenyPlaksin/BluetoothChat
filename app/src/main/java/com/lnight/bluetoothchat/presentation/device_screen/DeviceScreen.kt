package com.lnight.bluetoothchat.presentation.device_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lnight.bluetoothchat.presentation.BluetoothViewModel

@Composable
fun DeviceScreen(
    navController: NavController,
    viewModel: BluetoothViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 34.dp)
    ) {
        BluetoothDeviceList(
            scannedDevices = state.scannedDevices,
            pairedDevices = state.pairedDevices,
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 34.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = viewModel::startScan,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                shape = MaterialTheme.shapes.small
            ) {
                Text(text = "Start scan")
            }
            Button(
                onClick = viewModel::stopScan,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                shape = MaterialTheme.shapes.small
            ) {
                Text(text = "Stop scan")
            }
        }
    }
}