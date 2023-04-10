package com.sist.board.service;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalcService extends JFrame {
    private JTextField inputSpace;
    private String num = "";
    private ArrayList<String> equation = new ArrayList<>();
    public CalcService(){
       setTitle("혜린's 계산기");
       setVisible(true);
       setSize(300,370);
        //화면의 가운데에 띄움
        setLocationRelativeTo(null);
        //사이즈조절 불가능
        setResizable(false);
        //창을 닫을 때 실행 중인 프로그램도 같이 종료되도록 함
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //계산기의 화면과 버튼을 붙임 - 기본 레이아웃 사용
        setLayout(null);

        //빈공간의 JTextField 생성
        inputSpace = new JTextField();
        //편집가능여부 : 불가능 (버튼만 사용)
        inputSpace.setEditable(false);
        //배경색 설정
        inputSpace.setBackground(Color.WHITE);
        //정렬위치 설정
        inputSpace.setHorizontalAlignment(JTextField.RIGHT);
        //글씨체 설정
        inputSpace.setFont(new Font("Arial", Font.BOLD, 50));
        //위치와 크기(x:8,y:10의 위치에 270x70의 크기)
        inputSpace.setBounds(8, 10, 270, 70);

        add(inputSpace);

        System.out.println("addinputspace까진 들어옴");
        //버튼을 만들 패널
        JPanel buttonPanel = new JPanel();
        //레이아웃 지정 - 격자형태로 배치해주는 GridLayout사용
        //GridLayout(4, 4, 10, 10) -> 가로 칸수, 세로 칸수, 좌우 간격, 상하 간격
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        //위치와 크기 설정
        buttonPanel.setBounds(8, 90, 270, 235);

        //계산기 버튼의 글자를 차례대로 배열에 저장
        String button_names[] = { "C", "÷", "×", "=", "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "0" };

        JButton buttons[] = new JButton[button_names.length];

        //배열을 이용하여 버튼 생성
        for(int i=0; i<button_names.length; i++){
            buttons[i] = new JButton(button_names[i]);
            //글씨체
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
            //버튼의 색 지정
            if (button_names[i] == "C") buttons[i].setBackground(Color.RED);
            else if ((i >= 4 && i <= 6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14)) buttons[i].setBackground(Color.BLACK);
            else buttons[i].setBackground(Color.GRAY);
            //글자색 지정
            buttons[i].setForeground(Color.WHITE);
            //테두리 없앱
            buttons[i].setBorderPainted(false);
            //밑에서 만든 액션리스너를 버튼에 추가
            buttons[i].addActionListener(new PadActionListener());
            //버튼들을 버튼패널에 추가
            buttonPanel.add(buttons[i]);
        }
        add(buttonPanel);
        System.out.println("for문 까진 들어옴");
    }

    class PadActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //어떤 버튼이 눌렸는지를 알아냄
            String operation = e.getActionCommand();
            System.out.println("operation:"+operation);

        }
    }

    public static void main(String[] args) {
        new CalcService();
    }
}
