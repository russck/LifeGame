package livegame;

import java.util.TimerTask;

public class Time extends TimerTask{
	
	private ChessBoard chessBoard;//ӵ�����̶���,�ɵ���play��������
	
	void setChessBoard(ChessBoard chessBoard){
		this.chessBoard=chessBoard;
	}
	
	ChessBoard getChessBoard(){
		return this.chessBoard;
	}
	
	//��дrun���������߳��ﲻ�ϵ���run�������ﵽ���ϸı�chessBoard��Ŀ��
	public void run() {
		//���̶������play���������仯���������ӵ�״̬
		chessBoard.play(chessBoard.getPanels());
	}

}
