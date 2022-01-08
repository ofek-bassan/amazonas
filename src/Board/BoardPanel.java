package Board;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class BoardPanel extends JPanel
{
	private Square _square;
	private ListenerMove l;  //  listener(only one needed  because the only listener is frame)
	private boolean _is_selected;
	
	public BoardPanel(Square square) {
		super();
		_square = square;
		_is_selected = false;
		repaint();
		addMouseListener(new MouseAdapter() //  when panel is pressed
				{
					public void mouseClicked(MouseEvent e)
					{
						l.change_pos(_square.get_row(), _square.get_col());  //  changes all colors according to i and j
					}
				});
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(_square.get_ColorBackground());
		if(_square.get_col() != 10 && _square.get_col() != 11)
		{
			if(_is_selected)
				g.fillRect(0, 0, g.getClipRect().width, g.getClipRect().height);
			else
				g.drawRect(0, 0, g.getClipRect().width, g.getClipRect().height);
		}
		else
		{
			if(_square.get_col() == 10)
				if(_is_selected)
					g.fillRect(0, 0, g.getClipRect().width, g.getClipRect().height);
				else
					g.drawRect(0, 0, 0, g.getClipRect().height);
		}
		_square.set_img();
		_square.get_img().set_img_cords(35, 10);
		_square.get_img().draw_img(g);
	}

	//  get square
	public Square get_square() {
		return _square;
	}
	
	//  change state of each cell
	public void change_state()
	{
		repaint();
	}
	
	//  add listener
    public void add_listener(ListenerMove to_add)
    {
    	l = to_add;
    }
    
    public void set_select(boolean flag)
    {
    	_is_selected = flag;
    }
}
