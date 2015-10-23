package lotto;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LottoUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	Lotto lotto;
	// 컴포넌트(스윙에서 화면을 나타내느 클래스)는 연관관계로 부모*자식 관계를 맺는다.
	JButton btn, btnTest, btnExit;
	JPanel panelNorth, panelSouth; // 보더 레이아웃 개념으로 볼때 동서남북으로 위치값을 줌.
	ImageIcon icon;
	List<JButton> btns;
	public LottoUI() {
		init();
		
	}
	
	public void init(){ // initialize의 약자로 초기화 메소드 이름으로 많이 사용함
		this.setTitle("SBS로또 추첨");
		lotto = new Lotto();
		btns = new ArrayList<JButton>();
		panelNorth = new JPanel();
		panelSouth = new JPanel();
		btn = new JButton("로또 번호 추첨");
		btnTest = new JButton("테스트");
		btnExit = new JButton("종료");
		
		btn.addActionListener(this);
		btnTest.addActionListener(this);
		btnExit.addActionListener(this);
		panelNorth.add(btn);
		panelNorth.add(btnTest);
		panelNorth.add(btnExit);
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelSouth, BorderLayout.SOUTH);
		this.setBounds(300,400,1200,300);
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "로또 번호 추첨":
			if (btns.size() == 0) {
				JButton temp = null;
				for (int i = 0; i < 6; i++) {
					temp = new JButton(); // 번호가 붙지않은 로또공 객체를 만들어라
					btns.add(temp); // 6회전이므로  로또볼  6개를 만들어 담아라
					panelSouth.add(temp); // 리스트에 담고, 또 그 로또볼을 패널에 붙여라
				}
			}
			lotto.setLotto(); // 로또볼 추첨에 들어갑니다.
			int[] temp = lotto.getLotto();
			for (int i = 0; i < temp.length; i++) {
				btns.get(i).setIcon(new ImageIcon("src/image/"+ temp[i]+".gif"));
			}
			this.setVisible(true);
			break;
		case  "테스트":
			System.out.println("테스트 입니다.");
			break;
		case "종료":
			System.out.println("종료합니다.");
			setVisible(false);
			System.exit(0);
			break;
		default:
			break;
		}
	}
}
