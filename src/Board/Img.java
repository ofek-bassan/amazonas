package Board;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Img
{
	private Image _image;
	private int x, y, width, height;
	
	//  Constructor
	public Img(String path, int x, int y, int width, int height)
	{
		_image = new ImageIcon(this.getClass().getClassLoader().getResource(path)).getImage(); 
		
		set_img_cords(x, y);
		set_img_size(width, height);
	}
	
	//  Draw Image
	public void draw_img(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D) g;
        		g2d.drawImage(_image, x, y, width, height, null);
	}
	
	//  set Image cords
	public void set_img_cords(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	//  set Image size
	public void set_img_size(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	//  set Image
	public void set_img(Image image)
	{
		_image = image;
	}
	

}
