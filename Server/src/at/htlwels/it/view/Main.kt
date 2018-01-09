package jfx

import at.htlwels.it.controller.TetrisArena
import javafx.application.Application
import javafx.application.Platform
import javafx.concurrent.Task
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import javafx.stage.Stage
import javafx.stage.StageStyle


class Main : Application() {

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        var loader = FXMLLoader()
        loader.location = javaClass.getResource("ui.fxml")
        val root = loader.load<Parent>()
        val controller: Controller = loader.getController()


        val arena1 = TetrisArena()
        val sleeptimer = 500L


        //Task konstrukt, wegen jfx Thread problem

        //GameLoop, only used for the regular ticks down
        val gameLoop = object : Task<Unit>() {
            @Throws(Exception::class)
            override fun call(): Unit {
                while (true) {
                    Platform.runLater({
                        arena1.moveTrockDown()
                    })
                    Thread.sleep(sleeptimer)
                }

            }
        }
        Thread(gameLoop).start()

        //drawLoop, used to update visuals
        val drawLoop = object : Task<Unit>() {
            @Throws(Exception::class)
            override fun call(): Unit {
                while (true) {
                    Platform.runLater({
                        controller.fillPane1(arena1)
                    })
                    Thread.sleep(50L)
                }

            }
        }
        Thread(drawLoop).start()


        val scene = Scene(root, 740.0, 740.0)
        scene.fill = Color.TRANSPARENT
        scene.stylesheets.add(javaClass.getResource("style.css").toExternalForm())
        primaryStage.title = "JFX_GAME"
        primaryStage.scene = scene
        primaryStage.initStyle(StageStyle.TRANSPARENT)
        primaryStage.show()

        scene.addEventHandler(KeyEvent.KEY_PRESSED) { key ->
            when (key.code) {
                KeyCode.S -> {
                    arena1.moveTrockDown()
                }
                KeyCode.A -> {
                    arena1.moveTrockRight()
                }
                KeyCode.D -> {
                    arena1.moveTrockLeft()
                }
                KeyCode.Q -> {
                    arena1.rotLeft()
                }
                KeyCode.E -> {
                    arena1.rotRight()
                }
            }
        }


    }

}

fun main(args: Array<String>) {
    Application.launch(Main::class.java)
}

