package livegame;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

public class ChessBoard {
	
	static  final int SIZE = 50;
	private final Color color = new Color(72,209,204);
	//�������Ƿ�������
	private boolean[][] table = new boolean[SIZE][SIZE];
	//�����ھ���Ŀ
	private int[][] neighbors = new int[SIZE][SIZE];
	//ÿ������
	JPanel panels[][]=new JPanel[SIZE][SIZE];
	
	protected void setPanels(JPanel panels[][]){
		this.panels=panels;
	}
	
	protected boolean[][] getTable() {
		return this.table;
		
	}
	protected JPanel[][] getPanels() {
		return this.panels;
	}
	
	protected void init1() {//��ʼ״̬:���Ϊ6��ʮ��
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if((i>=22&&i<=27)||(j>=22&&j<=27)){
					table[i][j]=true;
					panels[i][j].setBackground(Color.red);
				}
				else{
					table[i][j]=false;
					panels[i][j].setBackground(color);
				}
			}
		}
	}
	
	protected void init2() {//��ʼ״̬12x12����
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if(i>=19&&i<=30&&j>=19&&j<=30){
					table[i][j]=true;
					panels[i][j].setBackground(Color.red);
				}
				else {
					table[i][j]=false;
					panels[i][j].setBackground(color);
					}
			}
		}
	}
	
	//���״̬
		protected void init3() {
	        Random r=new Random();
	        double n;
	        for(int i = 0;i < SIZE;i++)
				for(int j = 0;j < SIZE;j++) {
					n = r.nextDouble();
					if(n > 0.5){
						table[i][j] = true;
						panels[i][j].setBackground(Color.red);
					}
					else{
						table[i][j] = false;
						panels[i][j].setBackground(color);}
				}
	}
		
//	//��ʼ��״̬��ǰ����,�ɴﵽ������ǰ�ƶ����Ӿ�Ч��
//	protected void init4() {//Ŀǰû���õ�����������չ
//		for(int i = 0;i < SIZE;i++)
//			for(int j = 0;j < SIZE;j++)
//				table[i][j] = false;
//		table[44][44] = true;
//		table[45][45] = true;
//		for(int i = 46,j = 43;j <= 45;j++)
//			table[i][j] = true;
//	}
//	
	
	//��ʼ���ھ�
	private void initNeighbors() {
		for(int i = 0;i < SIZE;i++)
			for(int j = 0;j < SIZE;j++) {
				neighbors[i][j] = 0;
			}
	}
	//����ھӸ���
	private void getNeighbors() {
		
		for(int r = 0;r < SIZE;r++){
			for(int c = 0;c < SIZE;c++) {
				if(r-1 >= 0 && c-1 >= 0 && table[r-1][c-1] )neighbors[r][c]++;
                if(r-1 >= 0 && table[r-1][c]) neighbors[r][c]++;
                if(r-1 >= 0 && c+1 < SIZE && table[r-1][c+1])neighbors[r][c]++;
                if(c-1 >= 0 && table[r][c-1]) neighbors[r][c]++;
                if(c+1 < SIZE && table[r][c+1]) neighbors[r][c]++;
                if(r+1 < SIZE && table[r+1][c]) neighbors[r][c]++;
                if(r+1 < SIZE && c+1 < SIZE && table[r+1][c+1])  neighbors[r][c]++;
                if(r+1 < SIZE && c-1 >=0 && table[r+1][c-1])  neighbors[r][c]++;               
			}
		}
	}
	
	//�����һ��״̬������
	private void nextWorld() {
	        for (int r = 0; r < SIZE; r++){//row
	            for (int c = 0; c < SIZE; c++){//column
	                if (neighbors[r][c] == 3){
	                    table[r][c] = true;
	                }//if (neighbors[r][c] == 2) ���ı�table[r][c]��
	                if (neighbors[r][c] < 2)
	                    table[r][c] = false; 
	                if (neighbors[r][c] >= 4)
	                    table[r][c] = false;                 
	                neighbors[r][c] = 0;                
	            }           
	        }
	 }
	//״̬�޸� ,�����޸ĺ����������
	protected boolean[][] next() {
		initNeighbors();
		getNeighbors();
		nextWorld();
		return this.table;
	}

	protected void play(JPanel[][] panels){
		boolean state[][]= next();
		
		for (int i = 0; i < SIZE; i++){
			for (int j = 0; j < SIZE; j++) {
				if(state[i][j]){
					panels[i][j].setBackground(Color.red);
				}else{
					//panels[i][j].setBackground(new Color(72,209,204));
					panels[i][j].setBackground(color);
				}
			}
		}
	}
}
