package net_impl.tetris_impl

import net_impl.tetris_impl.Stepz
import net_impl.tetris_impl.Trock
import net.GameArea
import java.security.SecureRandom




class TetrisArena : GameArea {
    //Array of Array of Pixel with start value 0
    var area: Array<IntArray> = Array(20, { IntArray(10, { 0 }) })
    var currTrock: Trock = Trock()


    fun moveLineUp(): Boolean {
        area[0].forEach { elem ->
            if (elem != 0) {
                return false
            }
        }

        var x = 0
        var y = 0
        while (y < 19) {
            while (x < 10) {
                area[y][x] = area[y + 1][x]
                x++
            }
            x = 0
            y++
        }

        var i: Int = 0
        while (i < 10) {
            area[19][i] = Math.abs(SecureRandom().nextInt() % 7)
            i++
        }
        area[19][Math.abs(SecureRandom().nextInt() % 9)] = 0
        return true
    }

    fun reset() {
        area = Array(20, { IntArray(10, { 0 }) })
        currTrock = Trock()
    }

    fun destroyLine(y: Int) {
        println("Line: ${y}")
        var x = 0
        var y1 = y

        while (x < 10) {
            assert(area[y1][x]!=0,{println("Problem detected")})
            area[y1][x] = 0
            x++
        }
        while (y1 < 19) {
            x = 0
            while (x < 10) {

                area[y1][x] = area[y1 + 1][x]
                x++
            }
            y1++
        }
    }

    fun check(kek: IntArray, newY: Int, newX: Int): Boolean {

        var x = 0
        var y = 0


        while (x < 4) {
            while (y < 4) {

                var y1 = y + currTrock.currY + newY
                var x1 = x + currTrock.currX + newX

                /**
                 * y starts negative
                if (kek[y * 4 + x] != 0) {
                if (y1 >= 0)
                if (x1 in 0..9 && y1 < 20){
                if (area[y1][x1] != 0)
                return false
                }else{
                return false
                }
                }*/

                if (kek[y * 4 + x] != 0) {
                    if (y1 < 20)
                        if (x1 in 0..9 && y1 >= 0) {
                            if (area[y1][x1] != 0)
                                return false
                        } else {
                            return false
                        }
                }
                y++
            }
            y = 0
            x++
        }


        return true
    }

    fun seekndestroy() {
        var x = 0
        var y = 0
        var zeilen: MutableList<Int> = ArrayList()
        var zeilenTerminator = 0
        while (y < 20) {
            while (x < 10) {
                if (area[y][x] != 0)
                    zeilenTerminator++
                x++
                //break wenn null drinn-> weit weniger laufzeit
                if (x != zeilenTerminator) break
            }
            if (zeilenTerminator == 10)
                zeilen.add(y-zeilen.size)

            zeilenTerminator = 0
            x = 0
            y++
        }

        zeilen.forEach { elem -> destroyLine(elem) }
    }

    fun moveTrockDown() {
        if (!check(currTrock.current(), -1, 0)) {
            area = intermediateArray()
            seekndestroy()
            currTrock = Trock()
            return
        }

        currTrock.currY--
    }

    fun moveTrockLeft() {
        if (!check(currTrock.current(), 0, -1))
            return
        currTrock.currX--
    }

    fun moveTrockRight() {
        if (!check(currTrock.current(), 0, 1))
            return
        currTrock.currX++
    }

    fun rotRight() {
        var rot = (currTrock.rotation + 1) % Stepz.meta[currTrock.currBlock].size
        if (!check(Stepz.meta[currTrock.currBlock][rot], 0, 0))
            return
        currTrock.rotation = rot
    }

    fun rotLeft() {
        val rot = (currTrock.rotation + Stepz.meta[currTrock.currBlock].size - 1) % Stepz.meta[currTrock.currBlock].size

        if (!check(Stepz.meta[currTrock.currBlock][rot], 0, 0))
            return

        currTrock.rotation = rot
    }

    fun toArray(): Array<IntArray> {
        return area
    }

    fun intermediateArray(): Array<IntArray> {
        var intermediateArena = Array(20, { IntArray(10) })
        var x = 0
        var y = 0
        var iter = 0

        while (y < 20) {
            while (x < 10) {
                intermediateArena[y][x] = area[y][x]
                x++
            }
            x = 0
            y++
        }
        while (iter < 16) {
            try {
                var y1 = currTrock.currY + (iter / 4)
                var x1 = currTrock.currX + (iter % 4)
                if (currTrock.current()[iter] != 0)
                    intermediateArena[y1][x1] = currTrock.current()[iter]

            } catch(e: ArrayIndexOutOfBoundsException) {
            }
            iter++
        }
        return intermediateArena
    }

    override fun toString(): String {
        var sb: StringBuilder = StringBuilder()
        intermediateArray().forEach { row -> row.forEach { pix -> sb.append(pix) };sb.append("\n") }
        return sb.toString()
    }
}