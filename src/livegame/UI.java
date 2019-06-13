package livegame;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class UI{
	
	private JFrame frame = new JFrame(); 
	private JPanel panel = new JPanel();
	private JMenuBar bar = new JMenuBar();
	private JMenu m1 = new JMenu("��ʼ��״");
	private JMenu m2 = new JMenu("״̬");
	private JMenuItem m11 = new JMenuItem("ʮ��");
	private JMenuItem m12 = new JMenuItem("����");
	private JMenuItem m13 = new JMenuItem("�����״");
	private JMenuItem m21 = new JMenuItem("��ʼ");
	private JMenuItem m22 = new JMenuItem("��ͣ");
	private ChessBoard chessBoard;
	private GridLayout grid = new GridLayout(ChessBoard.SIZE,ChessBoard.SIZE,1,1);
	private JPanel [][]jps = new JPanel[ChessBoard.SIZE][ChessBoard.SIZE];

	protected ChessBoard getChessBoard() {
		return this.chessBoard;
	}
	
	protected void setChessBord(ChessBoard chessBoard) {
		this.chessBoard=chessBoard;
	}
	
	protected JFrame getFrame(){
		return this.frame;
	}
	
	protected JPanel getPanel() {
		return this.panel;
	}
	
	protected JPanel[][] getJps() {
		return this.jps;
	}
	
	protected JMenuItem getM21() {
		return this.m21;
	}
	
	protected JMenuItem getM22() {
		return this.m22;
	}
	
	protected void playUI() {
		frame.setSize(1000,720);
		frame.setTitle("������Ϸ");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		m1.add(m11);
		m1.add(m12);
		m1.add(m13);
		/*
		 * 
		 * 
		 .....����չ��ʼ��״......
		 */
		m2.add(m21);
		m2.add(m22);
		bar.add(m1);
		bar.add(m2);
		
		panel.setLayout(grid);
		for(int i = 0;i < ChessBoard.SIZE;i++)
			for(int j = 0;j  < ChessBoard.SIZE;j++) {
				jps[i][j] = new JPanel();
				jps[i][j].setBackground(new Color(72,209,204));
				panel.add(jps[i][j]);
			}
		
		m11.addActionListener(new ShapeListener());
		
		m12.addActionListener(new ShapeListener());
		
		m13.addActionListener(new ShapeListener());
		
		m21.addActionListener(new StateListener());
		
		m22.addActionListener(new StateListener());
		m22.setEnabled(false);
		
		frame.add(panel);
		frame.setJMenuBar(bar);
		frame.setVisible(true);
	}
}

