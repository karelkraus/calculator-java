import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener  {
	
	ImageIcon icon = new ImageIcon("calc.png");
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton negButton, decButton, eqButton, delButton, clrButton;
	JPanel panel;
	
	Font myFont = new Font("Verdana",Font.PLAIN, 30);
	
	double num1=0, num2=0, result=0;
	char operator;
	
	MyFrame() {
		
		this.setTitle("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450,550);
		this.setLayout(null);
		this.setIconImage(icon.getImage());
		this.setLocationRelativeTo(null);
		
		textField = new JTextField("0");
		textField.setBounds(20,15,395,70);
		textField.setFont(new Font("Verdana",Font.PLAIN, 40));
		textField.setHorizontalAlignment(JTextField.RIGHT);;
		textField.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		eqButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("C");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = eqButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i=0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setBackground(Color.black);
			functionButtons[i].setForeground(Color.white);
			functionButtons[i].setFocusable(false);
		}
		
		for(int i=0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setBackground(Color.black);
			numberButtons[i].setForeground(Color.white);
			numberButtons[i].setFocusable(false);
		}
		
		negButton.setBounds(20,100,125,50);
		clrButton.setBounds(155,100,125,50);
		delButton.setBounds(290,100,125,50);
		
		panel = new JPanel();
		panel.setBounds(20,180,395,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(eqButton);
		panel.add(divButton);
		
		this.add(panel);
		this.add(negButton);
		this.add(clrButton);
		this.add(delButton);
		this.add(textField);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource()==numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource()==decButton) {
			if(!textField.getText().contains(".")) {
				textField.setText(textField.getText().concat("."));
			}
		}
		
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("0");
		}
		
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("0");
		}

		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("0");
		}

		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("0");
		}
		
		if(e.getSource()==eqButton) {
			num2 = Double.parseDouble(textField.getText());
			
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		
		if(e.getSource()==clrButton) {
			textField.setText("");
		}
		
		if(e.getSource()==delButton) {
			String string = textField.getText();
			textField.setText("");
			for(int i = 0;i<string.length()-1;i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}
		}
		
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}
		
	}

}
