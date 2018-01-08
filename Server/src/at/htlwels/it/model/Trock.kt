package at.htlwels.it.model

import java.security.SecureRandom

class Trock(var currBlock: Int = Math.abs(SecureRandom().nextInt() % 7), var rotation: Int = 0, var currY: Short = 22, var currX: Short = 4) {
    fun current(): IntArray {
        return Stepz.meta[currBlock][rotation]
    }
}
/*
object Textures {
    val texture: Array<Texture> = arrayOf(Texture("transparent.png"), Texture("cyan.png"), Texture("yellow.png"), Texture("blue.png"), Texture("orange.png"), Texture("purple.png"), Texture("green.png"), Texture("red.png"))
}
*/
object Stepz {
    internal var meta = arrayOf(

            arrayOf(// LETTER I
                    intArrayOf(0, 0, 0, 0, /* 0/0 -- 0/3 */
                            1, 1, 1, 1, /* 1/0 -- 1/3 */
                            0, 0, 0, 0, /* 2/0 -- 2/3 */
                            0, 0, 0, 0  /* 3/0 -- 3/3 ## y*4+x*/), intArrayOf(0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0)), arrayOf(//LETTER O
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 2, 2, 0)), arrayOf(//LETTER J
            intArrayOf(0, 0, 0, 0, 3, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 3, 3, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 3, 0), intArrayOf(0, 0, 0, 0, 0, 3, 3, 0, 0, 3, 0, 0, 0, 3, 0, 0)), arrayOf(//LETTER L
            intArrayOf(0, 0, 0, 0, 0, 0, 4, 0, 4, 4, 4, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 4, 4, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 0, 4, 0, 0, 0), intArrayOf(0, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 4, 4, 0, 0)), arrayOf(//LETTER T
            intArrayOf(0, 0, 0, 0, 0, 5, 0, 0, 5, 5, 5, 0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0, 5, 0, 0, 5, 5, 0, 0, 0, 5, 0, 0), intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 0, 0, 5, 0, 0), intArrayOf(0, 0, 0, 0, 0, 5, 0, 0, 0, 5, 5, 0, 0, 5, 0, 0)), arrayOf(//LETTER S
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 0, 0, 6, 6, 0), intArrayOf(0, 0, 0, 0, 0, 6, 0, 0, 6, 6, 0, 0, 6, 0, 0, 0)), arrayOf(//LETTER Z
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 7, 0, 7, 7, 0, 0), intArrayOf(0, 0, 0, 0, 7, 0, 0, 0, 7, 7, 0, 0, 0, 7, 0, 0)))
}