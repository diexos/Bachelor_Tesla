package com.example.virosample

import java.io.IOException
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket
import java.sql.SQLException

object Server {

    @Throws(IOException::class, SQLException::class, ClassNotFoundException::class)
    @JvmStatic
    fun main(args: Array<String>) {

        val server = ServerSocket(9999)

        println("Waiting for clients to connect...")

        while (true) {
            val s = server.accept()
            val clientAddress = s.inetAddress
            println("Incoming connection from: " + clientAddress.hostName + "[" + clientAddress.hostAddress + "]")

            s.close()
        }
    }
}