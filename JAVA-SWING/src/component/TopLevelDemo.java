package component;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

/* TopLevelDemo.java requires no other files. */
	public class TopLevelDemo {
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("탑 레벨 예제");
	        // 프레임을 닫는 이벤트
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //메뉴바 생성 코드... 바탕색과 크기를 설정하는 코드
	        JMenuBar greenMenuBar = new JMenuBar();
	        greenMenuBar.setOpaque(true);
	        greenMenuBar.setBackground(new Color(0, 84, 225)); // 바탕색
	        greenMenuBar.setPreferredSize(new Dimension(200, 20)); // 크기
	 
	        // 라벨 생성
	        JLabel yellowLabel = new JLabel();
	        yellowLabel.setOpaque(true);  // 투명도
	        yellowLabel.setBackground(new Color(248, 213, 131));
	        yellowLabel.setPreferredSize(new Dimension(200, 180));
	 
	        // 메뉴바 생성 보더레이아웃은 중앙정렬이 가능하다.
	        frame.setJMenuBar(greenMenuBar);
	        frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);
	 
	        // pack() 메소느든 컴퍼넌트를 팩킹시키는 역활 
	        frame.pack();
	        frame.setVisible(true); 
	    }
	 
	    public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
	}