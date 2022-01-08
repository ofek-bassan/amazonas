package Board;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TurnPanel extends JPanel
{
	private boolean _draw;  //  tells if to draw the line for the board
	private JLabel _label;  //  the label
	
	public TurnPanel(boolean draw) {
		super();
		setBackground(Color.WHITE);
		
		//  sets the label
		_label = new JLabel();
		_label.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		add(_label);
		_draw = draw;
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(_draw)
			g.drawRect(0, 0, 0, 104);
	}
	
	//  returns the label
	public JLabel get_label()
	{
		return _label;
	}

}
