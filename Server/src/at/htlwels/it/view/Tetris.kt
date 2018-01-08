package at.htlwels.it.view
/*
import at.htlwels.it.controller.GameThread
import at.htlwels.it.model.Textures
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch



object Tetris : ApplicationAdapter() {
    var batch: SpriteBatch? = null
    var gt: GameThread?=null
    var background: Sprite? = null

    override fun create() {
        batch = SpriteBatch()
        background = Sprite(Texture("background.jpg"))
        gt = GameThread()
        gt!!.start()
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)


        batch!!.begin()
        batch!!.draw(background,0f,0f)
        drawArena(batch!!)
        handleInput()
        batch!!.end()
    }

    override fun dispose() {
        batch!!.dispose()
    }


    fun handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.S))
            gt!!.arena.moveTrockDown()
        else if (Gdx.input.isKeyJustPressed(Input.Keys.A))
            gt!!.arena.moveTrockLeft()
        else if (Gdx.input.isKeyJustPressed(Input.Keys.D))
            gt!!.arena.moveTrockRight()
        else if (Gdx.input.isKeyJustPressed(Input.Keys.Q))
            gt!!.arena.rotLeft()
        else if (Gdx.input.isKeyJustPressed(Input.Keys.E))
            gt!!.arena.rotRight()
    }

    fun drawArena(batch: SpriteBatch) {
        var intermediateArena: Array<Array<Int>> = Array(20, { Array(10, { 0 }) })
        var x = 0
        var y = 0
        var iter = 0
        while (y < 20) {
            while (x < 10) {
                intermediateArena[y][x] = gt!!.arena.area[y][x]
                x++
            }
            x = 0
            y++
        }
        while (iter < 16) {
            var y1 = gt!!.arena.currTrock.currY + (iter / 4)
            var x1 = gt!!.arena.currTrock.currX + (iter % 4)
            if (y1 in 0..19 && x1 in 0..9)
                if (gt!!.arena.currTrock.current()[iter] != 0)
                    intermediateArena[y1][x1] = gt!!.arena.currTrock.current()[iter]

            iter++
        }



        x = 0
        y = 19
        while (y >= 0) {
            while (x < 10) {
                //GEISTIG BEHINDERT
                batch.draw(Textures.texture[intermediateArena[y][x]], x.toFloat() * 32, y.toFloat() * 32)
                x++
            }
            x = 0
            y--
        }

        return
    }
}
*/