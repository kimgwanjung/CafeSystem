package Cafe;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class CoffeeSystemUsingGUI {
	
	// JPanel�Ӽ��� ��ӹ��� �̹��� �г� ����, �̹����� �׸��� ���� 
	@SuppressWarnings("serial")
	static class ImagePanel extends JPanel{
		// 1�����: img�� ���� �����ϰ� �Ʒ��� ��� ���ֱ�
		private Image img;		
		public ImagePanel (Image img) {
			this.img = img; 
		}
		//�׸��� ���� ���ȭ�� 
		public void paintComponent (Graphics g) {
			g.drawImage(img, 0,0,1900,1200,null);
		
		}
	}
	public static void main(String[] args) {
		JFrame fr = new JFrame("ī���ֹ��ý���");
		// �̹��� �г� �׸���
        ImagePanel pn =new ImagePanel(new ImageIcon("src/images/���ȭ��.jpg").getImage());
        fr.pack();
        fr.add(pn);
        JPanel drinkpn = new JPanel();
        JPanel cakepn = new JPanel();
        JPanel sandwichpn = new JPanel();
        JPanel Orderpn = new JPanel();
        
        //�ֹ�����
        JTextArea ordertxt = new JTextArea(); 
       

        //�ֹ������� Ȯ���Ҽ��ִ� �ؽ�Ʈ �ʵ带 ���̰�, �����߰�
        pn.add(ordertxt);     
        ordertxt.append("<�ֹ� ����> \n\n");
        ordertxt.setBounds(900,0, 400, 600); // �ֹ��ѳ����� �����ִ� txtarea�� ����       
        ordertxt.setEditable(false);
        ordertxt.setFont(new Font("���� ���",Font.BOLD,20));
        
        
        JTextArea listtxt = new JTextArea();
        listtxt.setBounds(250 ,300, 800, 600);
        listtxt.setFont(new Font("���� ���",Font.BOLD,35));
        
        JButton[] bt = new JButton[5];
        JButton order_bt = new JButton("�ֹ����");
        
        // �޴��� ���̺� �����
        String [] heading = new String[] {"��ǰ��","����"};
        Object[][] data = new Object [][] {
        	{"                    ��ǰ��","                     ����"},
        	{"�Ƹ޸�ī��","1500��"},
        	{"īǪġ��","2500��"},
        	{"��������ũ","3000��"},
        	{"��������ũ","3000��"},
        	{"��ġ�������ġ","4000��"},
        	{"���ڶ������ġ","4000��"},
        };     
        
        JTable table = new JTable(data,heading);
        pn.add(new JScrollPane(table));
        pn.add(table);
        table.setBounds(250, 0, 1100, 800);
        table.setFont(new Font("���� ���",Font.BOLD,30));
        table.setRowHeight(100);
        //��ư�� ��ġ�� ũ�� ����
        int width[]= {250,250,290,250,250};
        int height[]= {80,80,80,80,80};
        int x[] = {0,0,-20,0,0};
        int y[] = {160,280,400,30,520};
        //�̹��� �г� ũ�⼳��
        pn.setLayout(null);
        pn.setBounds(0,0,1900,1200);
        // �� �޴��� Vector ��ü�ӿ� �̸� �����س���
        CoffeeSystem.setupMenu(); 
       
        //���� ��ư 6�� ����
        bt[0] = new JButton("����"); 
        bt[1] = new JButton("����ũ"); 
        bt[2] = new JButton("������ġ");
        bt[3] = new JButton("����");
        bt[4] = new JButton("�ֹ�");

        for (int i = 0; i < bt.length; i++) {
            pn.add(bt[i]);
            bt[i].setBounds(x[i], y[i], width[i], height[i]);
            // ��Ʈ ����
            bt[i].setFont(new Font("���� ���", Font.BOLD, 50));
            //��ư�� �����ϰ� �����, ��ư�۾� ���� ����
            bt[i].setContentAreaFilled(false);
            bt[i].setBorderPainted(false);
            bt[i].setFocusPainted(false);
            bt[i].setForeground(Color.WHITE);
        }
        
        //��ư 0���� ��ɼ���
        bt[0].addActionListener(new ActionListener () {
        	 
            @Override
            public void actionPerformed(ActionEvent e) {
            	JButton srcBtn =(JButton)e.getSource();
                if(srcBtn==bt[0]) {
                	dodrink();
                	
                	//drinkpn �� ũ�� �� ����
                	drinkpn.setLayout(null);
    				drinkpn.setBounds(250, 0, 1050, 900);
    				drinkpn.setBackground(Color.gray);
                	
    				//drinkpn ������, ������ �г��� ������ �ʰ��ϱ�
                	drinkpn.setVisible(true);
                	cakepn.setVisible(false);   	
                	sandwichpn.setVisible(false);
                	Orderpn.setVisible(false);
                	ordertxt.setVisible(true);
                
                	table.setVisible(false);
                	order_bt.setVisible(true);
                }
            }

			private void dodrink() {	
				// drinkpn�� ������ ������ ��ư���� ����
				JButton drinkButton_�Ƹ޸�ī�� = new JButton("");
				fr.add(drinkpn);
				drinkButton_�Ƹ޸�ī��.setIcon(new ImageIcon("src/images/�Ƹ޸�ī��.JFIF"));
				drinkpn.add(drinkButton_�Ƹ޸�ī��);
				drinkButton_�Ƹ޸�ī��.setBounds(20, 20, 260,195);
				//�޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField drink_�Ƹ޸�ī�� = new JTextField("�Ƹ޸�ī��  1500��"); 
				drinkpn.add(drink_�Ƹ޸�ī��);
				drink_�Ƹ޸�ī��.setBounds(20,215,260,30);
				drink_�Ƹ޸�ī��.setEditable(false);
				
				// �Ƹ޸�ī�븦 ������ �˸�â�� �߰Բ� ��� ����
				drinkButton_�Ƹ޸�ī��.addActionListener(new ActionListener () {
			        	 
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	JButton srcBtn =(JButton)e.getSource();
			                if(srcBtn==drinkButton_�Ƹ޸�ī��) {
			            int result=	JOptionPane.showConfirmDialog(drinkButton_�Ƹ޸�ī��, "�Ƹ޸�ī�븦 �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
			                	if(result == JOptionPane.OK_OPTION) {
			                		ordertxt.append((CoffeeSystem.drink.get(0).toString()));
			                		CoffeeSystem.order.add(CoffeeSystem.drink.get(0));
			                		CoffeeSystem.new_Price(1500);
			                	}
			                }
			            }});
				
				JButton dirnkButton_īǪġ�� = new JButton("");
				dirnkButton_īǪġ��.setIcon(new ImageIcon("src/images/īǪġ��.JFIF"));
				drinkpn.add(dirnkButton_īǪġ��);
				dirnkButton_īǪġ��.setBounds(280, 20, 259, 194);
				//�޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField īǪġ�� = new JTextField("īǪġ��  2500��"); 
				drinkpn.add(īǪġ��);
				īǪġ��.setBounds(280,215,260,30);
				īǪġ��.setEditable(false);
				// īǪġ�븦 ������ �˸�â�� �߰Բ� ����
				dirnkButton_īǪġ��.addActionListener(new ActionListener () {	        	 
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	JButton srcBtn =(JButton)e.getSource();
		                if(srcBtn==dirnkButton_īǪġ��) {
		                	int result = JOptionPane.showConfirmDialog(dirnkButton_īǪġ��, "īǪġ�븦 �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
		                	if(result == JOptionPane.OK_OPTION) {
		                		ordertxt.append((CoffeeSystem.drink.get(1).toString()));
		                		CoffeeSystem.order.add(CoffeeSystem.drink.get(1));
		                		CoffeeSystem.new_Price(2500);
		                		
		                	}
		                	
		                }
		            }});
			}

    }
        
     );
        //bt[0] �� ���� ����
        bt[1].addActionListener(new ActionListener () {
       	 
            @Override
            public void actionPerformed(ActionEvent e) {
            	JButton srcBtn =(JButton)e.getSource();
                if(srcBtn==bt[1]) {
                	doICE();
                	
                	cakepn.setLayout(null);
				    cakepn.setBounds(250, 0, 1050, 900);
				    cakepn.setBackground(Color.gray);
				    
                	drinkpn.setVisible(false);
                	cakepn.setVisible(true);
                	sandwichpn.setVisible(false);
                	Orderpn.setVisible(false);
                	ordertxt.setVisible(true);
               
                	table.setVisible(false);
                	order_bt.setVisible(true);
                }
            }

			private void doICE() {
				
				fr.add(cakepn);
				JButton cakeButton_��������ũ = new JButton("");								
				cakeButton_��������ũ.setIcon(new ImageIcon("src/images/��������ũ.JFIF"));
				cakepn.add(cakeButton_��������ũ);
				cakeButton_��������ũ.setBounds(20, 20, 259,194);
				//�޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField cake_��������ũ = new JTextField("��������ũ  3000��"); 
				cakepn.add(cake_��������ũ);
				cake_��������ũ.setBounds(20,215,260,30);
				cake_��������ũ.setEditable(false);
				//��ư ��� �߰�
				cakeButton_��������ũ.addActionListener(new ActionListener () {
		        	 
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	JButton srcBtn =(JButton)e.getSource();
		                if(srcBtn==cakeButton_��������ũ) {
		                	int result = JOptionPane.showConfirmDialog(cakeButton_��������ũ, "��������ũ�� �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
		                	if(result == JOptionPane.OK_OPTION) {
		                		ordertxt.append((CoffeeSystem.cake.get(0).toString()));
		                		CoffeeSystem.order.add(CoffeeSystem.cake.get(0));
		                		CoffeeSystem.new_Price(3000);
		                	}
		                	
		                }
		            }});			
		        // �̹��� ũ�������ϱ�!
				ImageIcon icon_��������ũ = new ImageIcon("src/images/��������ũ.jfif");						
				JButton cakeButton_��������ũ = new JButton(CoffeeSystem.resizeIcon(icon_��������ũ, 259, 194));				
				cakepn.add(cakeButton_��������ũ);
				cakeButton_��������ũ.setBounds(280, 20, 259,194);
				//�޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField cake_��������ũ = new JTextField("��������ũ  3000��"); 
				cakepn.add(cake_��������ũ);
				cake_��������ũ.setBounds(280,215,260,30);
				cake_��������ũ.setEditable(false);
				//��ư ��� �߰�
				cakeButton_��������ũ.addActionListener(new ActionListener () {
		        	 
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	JButton srcBtn =(JButton)e.getSource();
		                if(srcBtn==cakeButton_��������ũ) {
		                	int result = JOptionPane.showConfirmDialog(cakeButton_��������ũ, "��������ũ�� �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
		                	if(result == JOptionPane.OK_OPTION) {
		                		ordertxt.append((CoffeeSystem.cake.get(1).toString()));
		                		CoffeeSystem.order.add(CoffeeSystem.cake.get(1));
		                		CoffeeSystem.new_Price(3000);
		                	}
		                	
		                }
		            }});
			}

    }
        
     );
        
        bt[2].addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn = (JButton)e.getSource();
				if(srcBtn==bt[2]) {
					dosandwich();
					
					sandwichpn.setLayout(null);
					sandwichpn.setBounds(250, 0, 1050, 900);
					sandwichpn.setBackground(Color.gray);				
					drinkpn.setVisible(false);
                	cakepn.setVisible(false);   	
                	sandwichpn.setVisible(true);
                	Orderpn.setVisible(false);
                	ordertxt.setVisible(true);
               
                	table.setVisible(false);
                	order_bt.setVisible(true);
				}
			}
        	
			private void dosandwich() {
			 fr.add(sandwichpn);
				JButton sandwichButton_��ġ�������ġ = new JButton(new ImageIcon("src/images/��ġ�������ġ.jpg"));
				sandwichpn.add(sandwichButton_��ġ�������ġ);
				sandwichButton_��ġ�������ġ.setBounds(20, 20, 259,194);
				//�޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField ��ġ�������ġ = new JTextField("��ġ�������ġ 4000��"); 
				sandwichpn.add(��ġ�������ġ);
				��ġ�������ġ.setBounds(20,215,260,30);
				��ġ�������ġ.setEditable(false);
				sandwichButton_��ġ�������ġ.addActionListener(new ActionListener () {
			        	 
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	JButton srcBtn =(JButton)e.getSource();
			                if(srcBtn==sandwichButton_��ġ�������ġ) {
			            int result=	JOptionPane.showConfirmDialog(sandwichButton_��ġ�������ġ, "��ġ�������ġ�� �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
			                	if(result == JOptionPane.OK_OPTION) {
			                		ordertxt.append((CoffeeSystem.sandwich.get(0).toString()));
			                		CoffeeSystem.order.add(CoffeeSystem.sandwich.get(0));
			                		CoffeeSystem.new_Price(4000);
			                	}
			                }
			            }
			});
				
				ImageIcon icon_���ڶ������ġ = new ImageIcon("src/images/���ڶ������ġ.jpeg");
				JButton sandwichButton_���ڶ������ġ = new JButton(CoffeeSystem.resizeIcon(icon_���ڶ������ġ, 260, 195));
				
				sandwichpn.add(sandwichButton_���ڶ������ġ);
				sandwichButton_���ڶ������ġ.setBounds(280, 20, 259,194);
				//�޴��̸� ����� �ؽ�Ʈ �ʵ� ����
				JTextField ���ڶ������ġ = new JTextField("���ڶ������ġ  4000��"); 
				sandwichpn.add(���ڶ������ġ);
				���ڶ������ġ.setBounds(280,215,260,30);
				���ڶ������ġ.setEditable(false);
				sandwichButton_���ڶ������ġ.addActionListener(new ActionListener () {
			        	 
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	JButton srcBtn =(JButton)e.getSource();
			                if(srcBtn==sandwichButton_���ڶ������ġ) {
			            int result=	JOptionPane.showConfirmDialog(sandwichButton_���ڶ������ġ, "���ڶ������ġ�� �ֹ��Ͻðٽ��ϱ�?", "�ֹ�Ȯ��",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
			                	if(result == JOptionPane.OK_OPTION) {
			                		ordertxt.append((CoffeeSystem.sandwich.get(1).toString()));
			                		CoffeeSystem.order.add(CoffeeSystem.sandwich.get(1));
			                		CoffeeSystem.new_Price(4000);
			                	}
			                }
			            }
			});
        }});
        // ����ȭ�� ��ư ���
        bt[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn =(JButton)e.getSource();
				if(srcBtn==bt[3]) {
					
					drinkpn.setVisible(false);
                	cakepn.setVisible(false);   	
                	sandwichpn.setVisible(false);
                	Orderpn.setVisible(false);
                	ordertxt.setVisible(false);
                	table.setVisible(true);
                	order_bt.setVisible(false);
				}
				
			}

        	
        });
        
        // �ֹ�����Ʈ ��ư ���
        bt[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn =(JButton)e.getSource();
				if(srcBtn==bt[4]) {
					fr.add(Orderpn);
					drinkpn.setVisible(false);
                	cakepn.setVisible(false);   	
                	sandwichpn.setVisible(false);
                	Orderpn.setVisible(true);
					ordertxt.setVisible(false);
					
					table.setVisible(false);
					order_bt.setVisible(false);
                
					Orderpn.add(listtxt);
                	Orderpn.setBounds(250, 0, 1050, 900);
					Orderpn.setBackground(Color.white);
		
				}
				
			}

			
        	
        });
        
        // �ֹ���� ��ư �߰� �� ����
        order_bt.setFont(new Font("���� ���", Font.PLAIN, 25));
        order_bt.setBounds(900, 600, 390, 90);
        pn.add(order_bt); // �ֹ���� ��ư ���� �� ���
        order_bt.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn =(JButton)e.getSource();
				if(srcBtn==order_bt) {
					int result=JOptionPane.showConfirmDialog(order_bt, "�ֹ��Ͻðڽ��ϱ�?", "�ֹ�Ȯ��",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(result==JOptionPane.OK_OPTION) {
											
						Custmoer_Order();	
						// �ֹ���� ��ư�� ������ �ֹ�����,�� �ֹ���� �� ��� ����� �ٽ� �ֹ����� ����
						ordertxt.setText("");
						int sum = 0;
						listtxt.append(CoffeeSystem.total_Price(sum));
						ordertxt.append("<�ֹ� ����>\n\n");
						CoffeeSystem.order.removeAllElements();
						CoffeeSystem.price.removeAllElements();
							
					}
				}
				
			}
			// �ֹ�����Ʈ�� ������ ������ ����
			private void Custmoer_Order() {
				
					Menu m;									
					listtxt.append("\n-------------------------��� �ֹ� ����--------------------------\n");
							
					// ��� �ֹ�����Ʈ�� �ҷ���
					for(int i=0; i<CoffeeSystem.getNumOrders(); i++) {	
						m=CoffeeSystem.getOrder(i);
						listtxt.append(i+1+". ");
						listtxt.append(m.toString());
										
					}
					
					listtxt.append("--------------------------------------------------------------------\n");
			
			}

        	
        });

        //ù ȭ�鿡�� �ֹ���� ������ �ʰ��ϱ�
        ordertxt.setVisible(false);
        order_bt.setVisible(false);
      
        //������ ����
        fr.setLocation(0,0);
        fr.setContentPane(pn);
        fr.setSize(1900	, 1600);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	
	}