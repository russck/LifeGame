package livegame;

//��ʼ����״�˵��ļ�����

class InitShape{
	static ChessBoard board;

	static protected void initShape(int index){
		switch (index) {
		case 0:
			board.init1();
			break;
		case 1:
			board.init2();
			break;
		case 2:
			board.init3();
			break;
		default:
			break;
		}
	}
}

