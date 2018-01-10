package view

import net_impl.tetris_impl.TetrisArena
import net_impl.tetris_impl.Images
import javafx.fxml.FXML
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane




class Controller {


    @FXML var pane1: GridPane? = null
    @FXML var pane2: GridPane? = null

    fun initialize() {
        //DO NUFFIN
    }

    fun fillPane1(arena: TetrisArena) {
        pane1!!.children.clear()
        for(i in 0..19)
            for(j in 0..9){
                    if(arena.area[i][j]!=0)
                        pane1!!.add(ImageView(Images.texture[arena.area[i][j]]),9-j,19-i)
            }


        for (iter in 0..15) {
            var y1 = arena.currTrock.currY + (iter / 4)
            var x1 = arena.currTrock.currX + (iter % 4)
            if (y1 in 0..19 && x1 in 0..9)
                if (arena.currTrock.current()[iter] != 0){
                    pane1!!.add(ImageView(Images.texture[arena.currTrock.current()[iter]]),9-x1,19-y1)
                }

        }
    }


    //UNUSED

//    fun getNodeAt(row:Int,col:Int):Node?{
//        return pane1!!.children.firstOrNull { GridPane.getColumnIndex(it)==col && GridPane.getRowIndex(it)==row }
//    }
}
