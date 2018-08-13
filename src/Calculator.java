import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

public class Calculator extends JFrame implements ActionListener {
	Container cp = this.getContentPane();// ����������
	JPanel pane = new JPanel();// �½��м�����
	JPanel pane1 = new JPanel();
	JPanel pane2 = new JPanel();
	JLabel text1 = new JLabel("����:");
	JLabel text2 = new JLabel("������:");
	JTextField j1 = new JTextField(120);
	JTextField j2 = new JTextField(120);
	String t;
	double h;

	// �½���ť���
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	JButton b0 = new JButton("0");
	JButton a1 = new JButton("+");
	JButton a2 = new JButton("-");
	JButton a3 = new JButton("*");
	JButton a4 = new JButton("/");
	JButton a5 = new JButton("^");
	JButton a6 = new JButton("%");
	JButton a7 = new JButton(".");
	JButton a8 = new JButton("(");
	JButton a9 = new JButton(")");
	JButton a0 = new JButton("clear");
	JButton c = new JButton("=");

	// ���췽��
	public Calculator() {

		super("лΰ���ļ��׼�����"); // ��ʼ������
		setBounds(400, 400, 360, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cp.add(pane, BorderLayout.CENTER);// ��ӵ����������
		cp.add(pane1, BorderLayout.NORTH);
		cp.add(pane2, BorderLayout.SOUTH);

		pane.setLayout(new GridLayout(5, 4, 6, 6));// �����ĳ��������
		pane1.setLayout(new GridLayout(0, 1, 12, 12));
		pane2.setLayout(new GridLayout());
		
		// ��ӵ��м������
		pane1.add(text1);
		pane1.add(j1);
		pane1.add(text2);
		pane1.add(j2);
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		pane.add(a1);
		pane.add(b4);
		pane.add(b5);
		pane.add(b6);
		pane.add(a2);
		pane.add(b7);
		pane.add(b8);
		pane.add(b9);
		pane.add(a3);
		pane.add(a6);
		pane.add(b0);
		pane.add(a5);
		pane.add(a4);
		pane.add(a8);
		pane.add(a9);
		pane.add(a7);
		pane.add(a0);
		pane2.add(c);

		// ��Ӽ�����
		a1.addActionListener(this);
		a2.addActionListener(this);
		a3.addActionListener(this);
		a4.addActionListener(this);
		a5.addActionListener(this);
		a6.addActionListener(this);
		a7.addActionListener(this);
		a8.addActionListener(this);
		a9.addActionListener(this);
		a0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		c.addActionListener(this);

	}

	// ��������ʵ��
	public void actionPerformed(ActionEvent e) {
		if ((JButton) e.getSource() == b1)
			j1.setText(j1.getText() + b1.getText());
		if ((JButton) e.getSource() == b2)
			j1.setText(j1.getText() + b2.getText());
		if ((JButton) e.getSource() == b3)
			j1.setText(j1.getText() + b3.getText());
		if ((JButton) e.getSource() == b4)
			j1.setText(j1.getText() + b4.getText());
		if ((JButton) e.getSource() == b5)
			j1.setText(j1.getText() + b5.getText());
		if ((JButton) e.getSource() == b6)
			j1.setText(j1.getText() + b6.getText());
		if ((JButton) e.getSource() == b7)
			j1.setText(j1.getText() + b7.getText());
		if ((JButton) e.getSource() == b8)
			j1.setText(j1.getText() + b8.getText());
		if ((JButton) e.getSource() == b9)
			j1.setText(j1.getText() + b9.getText());
		if ((JButton) e.getSource() == b0)
			j1.setText(j1.getText() + b0.getText());
		if ((JButton) e.getSource() == a1)
			j1.setText(j1.getText() + a1.getText());
		if ((JButton) e.getSource() == a2)
			j1.setText(j1.getText() + a2.getText());
		if ((JButton) e.getSource() == a3)
			j1.setText(j1.getText() + a3.getText());
		if ((JButton) e.getSource() == a4)
			j1.setText(j1.getText() + a4.getText());
		if ((JButton) e.getSource() == a5)
			j1.setText(j1.getText() + a5.getText());
		if ((JButton) e.getSource() == a6)
			j1.setText(j1.getText() + a6.getText());
		if ((JButton) e.getSource() == a7)
			j1.setText(j1.getText() + a7.getText());
		if ((JButton) e.getSource() == a8)
			j1.setText(j1.getText() + a8.getText());
		if ((JButton) e.getSource() == a9)
			j1.setText(j1.getText() + a9.getText());
		if ((JButton) e.getSource() == a0)
			j1.setText("");
		if ((JButton) e.getSource() == c) {
			t=Change(j1.getText());    //��ɺ�׺���ʽ
			System.out.println(t);
			h=Calc(t);
			j2.setText(""+String.format("%.4f", h));

		}
	}

	// ��׺���ʽת�ɺ�׺���ʽ
	String Change(String infix) {
		Stack<Character> stack = new Stack<Character>();// ����һ������ջ
		String suffix = ""; // ��ź�׺���ʽ���ַ���
		int length = infix.length();// �����׺���ʽ�ĳ���
		for (int i = 0; i < length; i++) {
			Character temp;
			char c = infix.charAt(i); // ���ַ����ֳ�����ַ�
			switch (c) {

			case ' ': // ���Կո�
				break;

			case '(': // ����'('��push��ջ
				stack.push(c);
				break;

			case ')':// ���������ţ�������ջ���ĵ�һ������������������ȫ�����ε���������������к��ٶ���������
				while (stack.size() != 0) {
					temp = stack.pop();
					if (temp == '('){
						break;
					}
					else{
						suffix += " " + temp;
				}
				}
				break;

			case '+': // ����'+''-'����ջ������������������͵����������
			case '-':
				while (stack.size() != 0) {
					temp = stack.pop();
					if (temp == '(') {
						stack.push('(');
					}else{
					suffix += " " + temp;
				}
				}
				stack.push(c);
				suffix += " ";
				break;

			case '*':// ����'*''/'����ջ�����г˳�������������͵����������,ֻ�б���С�ľͽ�ջ
			case '/':
			case '%':
				while (stack.size() != 0) {
					temp = stack.pop();

					if (temp == '(' || temp == '+' || temp == '-') {
						stack.push(temp);
						break;
					} else {
						suffix += " " + temp;
					}
				}
				stack.push(c);
				suffix += " ";
				break;

			case '^':// ����^�����
				while (stack.size() != 0) {
					temp = stack.pop();
					if (temp == '(' || temp == '+' || temp == '-' || temp == '*' || temp == '%' || temp == '/'||temp=='^') {
						stack.push(temp);
						break;
					} else {
						suffix += " " + temp;
					}
				}
				stack.push(c);
				suffix += " ";
				break;

			default:     // ��������֣�ֱ�������������
				suffix += c;
			}
		}

		while (stack.size() != 0) { // ���ջ��Ϊ�գ���ʣ�����������ε���������������С�
			suffix += " " + stack.pop();
		}
		return suffix;
	}

	// ͨ����׺���ʽ����������
	double Calc(String postfix) {
		Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)"); // ʹ��������ʽ //
																	// ƥ������
		String strings[] = postfix.split(" "); // ���ַ���ת��Ϊ�ַ�������
		Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < strings.length; i++)
			strings[i].trim(); // ȥ���ַ�����β�Ŀո�

		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals(""))
				continue;

			// ��������֣����ջ
			if ((pattern.matcher(strings[i])).matches()) {
				stack.push(Double.parseDouble(strings[i]));
			} else {
				// ��������������������������������
				double y = stack.pop();
				double x = stack.pop();
				stack.push(getCalc(x, y, strings[i])); // ������������ѹ��ջ��
			}
		}
		return stack.pop(); // ����ջ��Ԫ�ؾ����������ս����

	}

	// ��ñ��ʽ��ֵ
	private static double getCalc(double x, double y, String simble) {
		if (simble.trim().equals("+"))
			return x + y;
		if (simble.trim().equals("-"))
			return x - y;
		if (simble.trim().equals("*"))
			return x * y;
		if (simble.trim().equals("/"))
			return x / y;
		if (simble.trim().equals("%"))
			return x % y;
		if (simble.trim().equals("^"))
			return Math.pow(x, y);
		return 0;
	}

	public static void main(String a[]) {
		Calculator calc = new Calculator();

	}

}
