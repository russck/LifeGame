package livegame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeListener implements ActionListener{
	
	public void actionPerformed(ActionEvent event) {
		try {
			String shape = event.getActionCommand();
			int index=0;
			switch (shape) {
			case "ʮ��":
				index=0;
				break;
			case "����":
				index=1;
				break;
			case "�����״":
				index=2;
				break;
			default:
				break;
			}
			//�˴�����index��ֵ��ChessBoard��Ķ������ĳһ��init()��������ʼ������
			InitShape.initShape(index);//InitShape���е�ChessBoard�������init()������ʼ����״
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
