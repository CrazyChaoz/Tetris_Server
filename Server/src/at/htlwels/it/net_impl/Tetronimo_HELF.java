package at.htlwels.it.net_impl;

import java.lang.reflect.Array;


public class Tetronimo_HELF {
	public static final int matrixI[][][] = {
			{ { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 1, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 0, 0 } } };
	public static final int matrixT[][][] = {
			{ { 0, 0, 0, 0 }, { 2, 2, 2, 0 }, { 0, 2, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 2, 0, 0 }, { 2, 2, 0, 0 }, { 0, 2, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 2, 0, 0 }, { 2, 2, 2, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 2, 0, 0 }, { 0, 2, 2, 0 }, { 0, 2, 0, 0 }, { 0, 0, 0, 0 } } };
	public static final int matrixL[][][] = {
			{ { 0, 0, 0, 0 }, { 0, 3, 3, 3 }, { 0, 3, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 3, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 3, 0 }, { 3, 3, 3, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 3, 0, 0 }, { 0, 3, 0, 0 }, { 0, 3, 3, 0 }, { 0, 0, 0, 0 } } };
	public static final int matrixJ[][][] = {
			{ { 4, 0, 0, 0 }, { 4, 4, 4, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 4, 4, 0 }, { 0, 4, 0, 0 }, { 0, 4, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 0, 0 }, { 4, 4, 4, 0 }, { 0, 0, 4, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 4, 0, 0 }, { 0, 4, 0, 0 }, { 4, 4, 0, 0 }, { 0, 0, 0, 0 } } };
	public static final int matrixZ[][][] = {
			{ { 0, 0, 0, 0 }, { 5, 5, 0, 0 }, { 0, 5, 5, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 0, 5, 0 }, { 0, 5, 5, 0 }, { 0, 5, 0, 0 }, { 0, 0, 0, 0 } } };
	public static final int matrixS[][][] = {
			{ { 0, 0, 0, 0 }, { 0, 6, 6, 0 }, { 6, 6, 0, 0 }, { 0, 0, 0, 0 } },
			{ { 0, 6, 0, 0 }, { 0, 6, 6, 0 }, { 0, 0, 6, 0 }, { 0, 0, 0, 0 } } };
	public static final int matrixO[][][] = { { { 0, 7, 7, 0 }, { 0, 7, 7, 0 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 } } };
	
	
	private int[][][] matrix;
	private int rotation;
	private int posX;
	private int posY;
	private int width;
	private int height;
	private int rotationSteps;
	private int id;

	public Tetronimo_HELF(int[][][] otherMatrix, int id, int width, int height, int rotationSteps)
	{
		this.id=id;
		this.matrix = otherMatrix;
		this.posX = 0;
		this.posY = 0;
		this.width = width;
		this.height = height;
		this.rotationSteps = rotationSteps;
		this.rotation = 0;
	}
	
	public Tetronimo_HELF(Tetronimo_HELF other)
	{
		this.id = other.id;
		this.matrix = other.matrix.clone();
		this.width = other.width;
		this.height = other.height;
		this.rotationSteps = other.rotationSteps;
	}
	
	
	public void reset()
	{
		this.posX=3;
		this.posY=0;
		this.rotation=0;
	}
	
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getId()
	{
		return this.id;
	}

	public int[][] toArray()
	{
		return matrix[rotation];
	}
	
	public void undoRotate()
	{
		if (rotation-1 >= 0)
			rotation--;
		else
			rotation = rotationSteps-1;		
	}
	
	public void rotate()
	{	
		if (rotation+1 < rotationSteps)
			rotation++;
		else
			rotation=0;
	}
	

	
	public String toString()
	{
		String s="";
		for (int x = 0; x < Array.getLength(matrix[0]); x++)
		{
			for (int y = 0; y < Array.getLength(matrix[0][0]); y++)
				if (matrix[rotation][x][y]!=0)
					s=s+"1";
				else
					s=s+"0";
			s=s+"\n";
		}
		return s;
	}


	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}
	
	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}


	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}


	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

}
