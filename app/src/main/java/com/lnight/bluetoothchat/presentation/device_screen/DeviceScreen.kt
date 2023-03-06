package com.lnight.bluetoothchat.presentation.device_screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun DeviceScreen(
    navController: NavController,
    viewModel: BluetoothDeviceViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = state.errorMessage) {
        state.errorMessage?.let { message ->
            Toast.makeText(
                context,
                message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    when {
        state.isConnecting -> {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(strokeCap = StrokeCap.Round)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Connecting...")
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = viewModel::disconnectFromDevice,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text("Stop server")
                }
            }
        }
        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 34.dp)
            ) {
                BluetoothDeviceList(
                    scannedDevices = state.scannedDevices,
                    pairedDevices = state.pairedDevices,
                    onClick = viewModel::connectToDevice,
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
                    Button(
                        onClick = viewModel::waitForIncomingConnections,
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                        shape = MaterialTheme.shapes.small
                    ) {
                        Text(text = "Start server")
                    }
                }
            }
        }
    }
}