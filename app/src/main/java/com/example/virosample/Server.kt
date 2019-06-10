package com.example.virosample



import io.tempo.Tempo
import java.io.File
import java.io.IOException
import java.net.ServerSocket
import java.sql.SQLException
import java.util.*


object Server {
    private var save_text = mutableListOf<String>()

    @Throws(IOException::class, SQLException::class, ClassNotFoundException::class)
    @JvmStatic
    fun main(args: Array<String>) {



            val server = ServerSocket(9999)
            println("Server running on port ${server.localPort}")

            while (true) {

                val client = server.accept()
                println("Client conected : ${client.inetAddress.hostAddress}")



                val scanner = Scanner(client.inputStream)
                while (scanner.hasNextLine()) {
                    val text = scanner.nextLine() + System.currentTimeMillis()
                    save_text.add(text)





                    println(text)
                }
                val fileName = "camera.txt"
                val myfile = File(fileName)
                myfile.printWriter().use { out ->

                    out.write(save_text.toString())

                }
                scanner.close()
                client.close()
            }



        }

    }








