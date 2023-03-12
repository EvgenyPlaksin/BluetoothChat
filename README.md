# Bluetooth Chat App

This is an Android app that allows you to chat with other devices over Bluetooth. This app uses Jetpack Compose for UI, Dagger-Hilt for DI, and Bluetooth API for bytes transfer.

## Technologies
- **UI** - [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **DI** - [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Data Transfer** - [Android Bluetooth](https://developer.android.com/guide/topics/connectivity/bluetooth)

## What is Bluetooth?

Bluetooth is a wireless technology used for short-range communication between devices. It enables devices to exchange data over short distances using radio waves in the 2.4 GHz frequency band.

## Connecting to a Bluetooth Device

Here's an example Kotlin code snippet that shows how to connect to a Bluetooth device:

```kotlin
val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
val pairedDevices: Set<BluetoothDevice>? = bluetoothAdapter?.bondedDevices

if (!pairedDevices.isNullOrEmpty()) {
    val device: BluetoothDevice? = pairedDevices.find { it.name == "My Bluetooth Device" }

    if (device != null) {
        val socket: BluetoothSocket = device.createRfcommSocketToServiceRecord(MY_UUID)
        socket.connect()
    }
}
```
In this example, we first get the default Bluetooth adapter on the device. Then, we get a list of all paired Bluetooth devices. We find the device we want to connect to based on its name and create an RFCOMM socket to the device's UUID. Finally, we connect to the socket.

## Transferring Data over Bluetooth
Once you have established a Bluetooth connection with a device, you can transfer data between the devices. In Bluetooth communication, data is sent and received as byte arrays.

Here's an example Kotlin code snippet that shows how to send a message over Bluetooth:

```kotlin
val outputStream: OutputStream = socket.outputStream
val message: String = "Hello, Bluetooth!"

outputStream.write(message.toByteArray())
```
In this example, we get the output stream from the Bluetooth socket and write a message to it as a byte array.

When receiving data over Bluetooth, you would use the input stream from the Bluetooth socket to read the incoming data.

## Conclusion
Bluetooth is a powerful technology that allows for short-range communication between devices. This Android app demonstrates how to use it with clean architecture and DI.
I hope this was helpful for you, if so, leave a star!⭐
