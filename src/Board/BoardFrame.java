package Board;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class BoardFrame extends JFrame implements ListenerMove
{
	private BoardPanel _bp [][];
	private int _curr_i;
	private int _curr_j;
	private boolean yellow_turn; //  tells if it's yellow turn
	private boolean red_turn; //  tells if it's red turn
	private int count_pressed;  //  each press tells the state of player
	private TurnPanel _t;
	private TurnPanel _t_turn_player;
	
	public BoardFrame()  
	{
		super();
		setLayout(new GridLayout(10,12)); //  sets layout
		
		_bp = new BoardPanel[10][12];  //  board Initialize
		
		_t = new TurnPanel(true);  //  the panel where the turn: label is
		
		_t_turn_player = new TurnPanel(false);  //  the panel which shows yellow or red depends on each turn

		yellow_turn = true;
		
		red_turn = false;
		
		count_pressed = 1;
		
		//  Initialize the panels
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 12; j++) {
				if( i== 0 && j == 10)  //  the place of turn: label
				{
					_t.get_label().setText("turn:");
					add(_t);
				}
				else if( i== 0 && j == 11)  //  the place of red/yellow
				{
					if(yellow_turn)
						_t_turn_player.get_label().setText("yellow");
					else if(red_turn)
						_t_turn_player.get_label().setText("red");
					add(_t_turn_player);
				}
				else
				{
					Square s = new Square(i, j, Color.white, true, Color_Soldier.EMPTY);
					_bp[i][j] = new BoardPanel(s);
					_bp[i][j].add_listener(this);
					add(_bp[i][j]);	
				}
			}
		}
		
		red_player_start();  //  red player
		yellow_player_start();  //  yellow player

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500, 1500);
		setVisible(true);
	}
	
	//  changes the position of player
	public void change_pos(int i, int j) 
	{
		if(count_pressed == 1)  //  state of moving a player's soldier 
		{
			if(yellow_turn)  //  if its yellow's turn
			{
				if(_bp[i][j].get_square().get_color() ==  Color_Soldier.YELLOW && 
				   _bp[i][j].get_square().get_place_soldier() == false)  //  checks if the cell has yellow's player
				{
					_curr_i = i;
					_curr_j = j;
					_bp[i][j].set_select(true);
					_bp[i][j].change_state();
					count_pressed++;
				}
			}
			else if(red_turn)  //  if its red's turn
			{
				if(_bp[i][j].get_square().get_color() ==  Color_Soldier.RED && 
				   _bp[i][j].get_square().get_place_soldier() == false)//  checks if the cell has red's player
				{
					_curr_i = i;
					_curr_j = j;
					_bp[i][j].set_select(true);
					_bp[i][j].change_state();
					count_pressed++;
				}
			}
		}
		else if(count_pressed == 2)  //  checks if the player wants to move the soldier
		{
			if(!(_bp[i][j].get_square().get_place_soldier()))
			{
				return;
			}
			
			//  turns the moved players cell to nothing because its about to get moved
			_bp[_curr_i][_curr_j].get_square().set_color(Color_Soldier.EMPTY);
			_bp[_curr_i][_curr_j].get_square().set_draw_soldier(false);
			_bp[_curr_i][_curr_j].get_square().set_place_soldier(true);
			_bp[_curr_i][_curr_j].set_select(false);
			_bp[_curr_i][_curr_j].change_state();
			
			
			//  changes the current cell to the moved one
			_curr_i = i;
			_curr_j = j;

			if(yellow_turn)  //  if its yellow's turn
			{
				_bp[_curr_i][_curr_j].get_square().set_color(Color_Soldier.YELLOW);
				yellow_turn = false;
				red_turn = true;
				_t_turn_player.get_label().setText("red");
			}

			else if(red_turn)  //  if its red's turn
			{
				_bp[_curr_i][_curr_j].get_square().set_color(Color_Soldier.RED);
				yellow_turn = true;
				red_turn = false;
				_t_turn_player.get_label().setText("yellow");
			}

			_bp[_curr_i][_curr_j].get_square().set_draw_soldier(true);
			_bp[_curr_i][_curr_j].get_square().set_place_soldier(false);
			_bp[_curr_i][_curr_j].change_state();
			
			count_pressed = 1;
		}
	}
	
	//  Red player start
	private void red_player_start()
	{
		_curr_i = 0;
		_curr_j = 3;
		_bp[0][3].get_square().set_color(Color_Soldier.RED);
		_bp[0][3].get_square().set_draw_soldier(true);
		_bp[0][3].get_square().set_place_soldier(false);
		_bp[0][3].change_state();
		
		_bp[0][6].get_square().set_color(Color_Soldier.RED);
		_bp[0][6].get_square().set_place_soldier(false);
		_bp[0][6].get_square().set_draw_soldier(true);
		_bp[0][6].change_state();
		
		_bp[3][0].get_square().set_color(Color_Soldier.RED);
		_bp[3][0].get_square().set_place_soldier(false);
		_bp[3][0].get_square().set_draw_soldier(true);
		_bp[3][0].change_state();
		
		_bp[3][9].get_square().set_color(Color_Soldier.RED);
		_bp[3][9].get_square().set_place_soldier(false);
		_bp[3][9].get_square().set_draw_soldier(true);
		_bp[3][9].change_state();
	}
	
	//  Yellow player start
	private void yellow_player_start()
	{

		_bp[6][0].get_square().set_color(Color_Soldier.YELLOW);
		_bp[6][0].get_square().set_place_soldier(false);
		_bp[6][0].get_square().set_draw_soldier(true);
		_bp[6][0].change_state();
		
		_bp[6][9].get_square().set_color(Color_Soldier.YELLOW);
		_bp[6][9].get_square().set_place_soldier(false);
		_bp[6][9].get_square().set_draw_soldier(true);
		_bp[6][9].change_state();
		
		_bp[9][3].get_square().set_color(Color_Soldier.YELLOW);
		_bp[9][3].get_square().set_place_soldier(false);
		_bp[9][3].get_square().set_draw_soldier(true);
		_bp[9][3].change_state();
		
		_bp[9][6].get_square().set_color(Color_Soldier.YELLOW);
		_bp[9][6].get_square().set_place_soldier(false);
		_bp[9][6].get_square().set_draw_soldier(true);
		_bp[9][6].change_state();
	}
	
}
