package at.htlwels.it.model;


/*
I Cyan
O Yellow
T Purple
S Green
Z Red
J Blue
L Orange
 */
public class Tetrock {
    int[][][] meta =
            {

                    {// LETTER I
                            {
                                    0, 0, 0, 0, /* 0/0 -- 0/3 */
                                    1, 1, 1, 1, /* 1/0 -- 1/3 */
                                    0, 0, 0, 0, /* 2/0 -- 2/3 */
                                    0, 0, 0, 0  /* 3/0 -- 3/3 ## y*4+x*/
                            }, {
                            0, 0, 1, 0,
                            0, 0, 1, 0,
                            0, 0, 1, 0,
                            0, 0, 1, 0
                    }
                    }, {//LETTER O
                    {
                            0, 0, 0, 0,
                            0, 0, 0, 0,
                            0, 2, 2, 0,
                            0, 2, 2, 0
                    }
            }, {//LETTER J
                    {
                            0, 0, 0, 0,
                            3, 0, 0, 0,
                            3, 3, 3, 0,
                            0, 0, 0, 0
                    }, {
                    0, 0, 0, 0,
                    0, 3, 0, 0,
                    0, 3, 0, 0,
                    3, 3, 0, 0
            }, {
                    0, 0, 0, 0,
                    0, 0, 0, 0,
                    3, 3, 3, 0,
                    0, 0, 3, 0
            }, {
                    0, 0, 0, 0,
                    0, 3, 3, 0,
                    0, 3, 0, 0,
                    0, 3, 0, 0
            }
            }, {//LETTER L
                    {
                            0, 0, 0, 0,
                            0, 0, 4, 0,
                            4, 4, 4, 0,
                            0, 0, 0, 0
                    }, {
                    0, 0, 0, 0,
                    4, 4, 0, 0,
                    0, 4, 0, 0,
                    0, 4, 0, 0
            }, {
                    0, 0, 0, 0,
                    0, 0, 0, 0,
                    4, 4, 4, 0,
                    4, 0, 0, 0
            }, {
                    0, 0, 0, 0,
                    4, 0, 0, 0,
                    4, 0, 0, 0,
                    4, 4, 0, 0
            }
            }, {//LETTER T
                    {
                            0, 0, 0, 0,
                            0, 5, 0, 0,
                            5, 5, 5, 0,
                            0, 0, 0, 0
                    }, {
                    0, 0, 0, 0,
                    0, 5, 0, 0,
                    5, 5, 0, 0,
                    0, 5, 0, 0
            }, {
                    0, 0, 0, 0,
                    0, 0, 0, 0,
                    5, 5, 5, 0,
                    0, 5, 0, 0
            }, {
                    0, 0, 0, 0,
                    0, 5, 0, 0,
                    0, 5, 5, 0,
                    0, 5, 0, 0
            }
            }, {//LETTER S
                    {
                            0, 0, 0, 0,
                            0, 0, 0, 0,
                            6, 6, 0, 0,
                            0, 6, 6, 0
                    }, {
                    0, 0, 0, 0,
                    0, 6, 0, 0,
                    6, 6, 0, 0,
                    6, 0, 0, 0
            }
            }, {//LETTER Z
                    {
                            0, 0, 0, 0,
                            0, 0, 0, 0,
                            0, 7, 7, 0,
                            7, 7, 0, 0
                    }, {
                    0, 0, 0, 0,
                    7, 0, 0, 0,
                    7, 7, 0, 0,
                    0, 7, 0, 0
            }
            }


            };
}
