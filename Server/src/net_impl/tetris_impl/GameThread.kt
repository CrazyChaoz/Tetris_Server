package net_impl.tetris_impl



//Simplest Tetris GameThread, used for libGDX GUI
class GameThread(var iterations:Long=500):Thread(){
    var arena: TetrisArena = TetrisArena()
    override fun run() {
        while (true) {
            arena.moveTrockDown()
            sleep(iterations)
        }
    }
}