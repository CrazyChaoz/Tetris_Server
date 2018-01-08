package at.htlwels.it.controller


class GameThread(var iterations:Long=500):Thread(){
    var arena: TetrisArena = TetrisArena()
    override fun run() {
        while (true) {
            arena.moveTrockDown()
            sleep(iterations)
        }
    }
}