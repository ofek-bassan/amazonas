package Board;

import java.awt.Color;

public class Square 
{
	private int _row;  //  Row
	private int _col;  //  Col
	private Color _ColorBackground;  //  Color background  
	private boolean _place_soldier;  //  Tells if you can put the soldier on index
	private boolean _draw_soldier;  //  Tells if you need to draw the soldier on index
	private Img _imgSoldier;  //  Image of soldier
	private Color_Soldier _color;  //  Color of soldier
	
	//  Constructor
	
	public Square(int row, int col, Color colorBackground, 
			boolean place_soldier,  
			Color_Soldier color) {
		//  row
		_row = row;
		
		// col
		_col = col;
		
		_ColorBackground = colorBackground;
		
		//  place soldier
		_place_soldier = place_soldier;
		
		//  image
		
		set_img();
		
		//  color of soldier
		_color = color;
		
		//  draw soldier
		_draw_soldier = false;
	}
	
	//  Get draw soldier
	public boolean set_draw_soldier() {
		return _draw_soldier;
	}
	
	//  Set draw soldier
	public void set_draw_soldier(boolean draw_soldier) {
		_draw_soldier = draw_soldier;
	}

	//  Get row
	public int get_row() {
		return _row;
	}
	
	//  Set row
	public void set_row(int _row) {
		this._row = _row;
	}
	
	//  Get col
	public int get_col() {
		return _col;
	}
	
	//  Set col
	public void set_col(int _col) {
		this._col = _col;
	}
	
	//  Get color
	public Color get_ColorBackground() {
		return _ColorBackground;
	}
	
	
	//  Set color
	public void set_ColorBackground(Color ColorBackground) {
		_ColorBackground = ColorBackground;
	}
	
	//  Get if can place soldier
	public boolean get_place_soldier() {
		return _place_soldier;
	}
	
	//  Set if can place soldier
	public void set_place_soldier(boolean _place_soldier) {
		this._place_soldier = _place_soldier;
	}
	
	//  Get color of soldier
	public Color_Soldier get_color() {
		return _color;
	}
	
	//  Set color of soldier
	public void set_color(Color_Soldier _color) {
		this._color = _color;
	}
	
	//  get Image
	public Img get_img()
	{
		return _imgSoldier;
	}
	
	//  set Image
	public void set_img()
	{
		if(_draw_soldier)
		{
			if(_color == Color_Soldier.RED)
			{
				_imgSoldier = new Img("img\\bqueen.png", 0, 0, 100, 100);
			}
			else
				_imgSoldier = new Img("img\\wqueen.png", 0, 0, 100, 100);
		}
		else
			_imgSoldier = new Img("img\\empty.png", 0, 0, 0, 0);

	}
}
