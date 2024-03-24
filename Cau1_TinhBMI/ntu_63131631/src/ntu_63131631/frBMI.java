package ntu_63131631;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class frBMI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_height;
	private JTextField txt_weight;
	private JTextField txt_bmi;

	public frBMI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 502, 102);
		panel.setBackground(new Color(241, 196, 15));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ứng Dụng Tính BMI");
		lblNewLabel_2.setBounds(36, 24, 426, 49);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lblNewLabel_1 = new JLabel("Chiều Cao (m):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 134, 176, 38);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_1_1 = new JLabel("Cân Nặng (Kg):");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(10, 192, 176, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Chỉ Số BMI Của Bạn:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(25, 311, 272, 38);
		contentPane.add(lblNewLabel_1_2);
		
		txt_height = new JTextField();
		txt_height.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txt_height.setBounds(196, 137, 272, 33);
		contentPane.add(txt_height);
		txt_height.setColumns(10);
		txt_weight = new JTextField();
		txt_weight.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txt_weight.setColumns(10);
		txt_weight.setBounds(196, 195, 272, 33);
		contentPane.add(txt_weight);
		
		txt_bmi = new JTextField();
		txt_bmi.setHorizontalAlignment(SwingConstants.CENTER);
		txt_bmi.setEnabled(false);
		txt_bmi.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txt_bmi.setColumns(10);
		txt_bmi.setBounds(328, 312, 140, 36);
		contentPane.add(txt_bmi);
		
		JButton btn_tinh = new JButton("Tính");
		btn_tinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TinhBMi();
			}
		});
		btn_tinh.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_tinh.setBounds(196, 240, 116, 43);
		contentPane.add(btn_tinh);
		
		JButton btn_exit = new JButton("Thoát");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn_exit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_exit.setBounds(352, 240, 116, 43);
		contentPane.add(btn_exit);
	}
	void TinhBMi() {
		float flbmi ;
		float flweight = Float.parseFloat(txt_weight.getText());
		float flheight = Float.parseFloat(txt_height.getText());
		flbmi = flweight /( flheight * flheight);
	    txt_bmi.setText(Float.toString(flbmi));
    	JOptionPane hopthoai = new JOptionPane();
	    if (flbmi < 18) {
			hopthoai.showMessageDialog(this, "Bạn là người gầy!");
	    } else if (flbmi <= 24.9) {
			hopthoai.showMessageDialog(this, "Bạn là người bình thường");
	    } else if (flbmi <= 29.9) {
			hopthoai.showMessageDialog(this, "Bạn bị béo phì độ I");
	    } else if (flbmi <= 34.9) {
			hopthoai.showMessageDialog(this, "Bạn bị béo phì độ II");
	    } else {
			hopthoai.showMessageDialog(this, "Bạn bị béo phì độ III");
	    }
	}

}
