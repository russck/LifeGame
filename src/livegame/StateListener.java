package livegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//״̬�˵��ļ�����
class StateListener implements ActionListener{
	
	public void actionPerformed(ActionEvent event) {
		try {
			String state = event.getActionCommand();
			int index=0;
			switch (state) {
			case "��ʼ":
				index=0;
				break;
			case "��ͣ":
				index=1;
			default:
				break;
			}
			//�˴�����index��ֵ��ChessBoard��Ķ������ĳһ��init()��������ʼ������
			InitState.initState(index);//InitShape���е�ChessBoard�������init()������ʼ����״
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
