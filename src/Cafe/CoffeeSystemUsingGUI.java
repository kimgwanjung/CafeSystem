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
	
	// JPanel속성을 상속받은 이미지 패널 설정, 이미지를 그리는 도구 
	@SuppressWarnings("serial")
	static class ImagePanel extends JPanel{
		// 1번방식: img를 먼저 선언하고 아래에 경로 써주기
		private Image img;		
		public ImagePanel (Image img) {
			this.img = img; 
		}
		//그리기 도구 배경화면 
		public void paintComponent (Graphics g) {
			g.drawImage(img, 0,0,1900,1200,null);
		
		}
	}
	public static void main(String[] args) {
		JFrame fr = new JFrame("카페주문시스템");
		// 이미지 패널 그리기
        ImagePanel pn =new ImagePanel(new ImageIcon("src/images/배경화면.jpg").getImage());
        fr.pack();
        fr.add(pn);
        JPanel drinkpn = new JPanel();
        JPanel cakepn = new JPanel();
        JPanel sandwichpn = new JPanel();
        JPanel Orderpn = new JPanel();
        
        //주문내역
        JTextArea ordertxt = new JTextArea(); 
       

        //주문내역을 확인할수있는 텍스트 필드를 붙이고, 내용추가
        pn.add(ordertxt);     
        ordertxt.append("<주문 내역> \n\n");
        ordertxt.setBounds(900,0, 400, 600); // 주문한내역을 볼수있는 txtarea를 생성       
        ordertxt.setEditable(false);
        ordertxt.setFont(new Font("맑은 고딕",Font.BOLD,20));
        
        
        JTextArea listtxt = new JTextArea();
        listtxt.setBounds(250 ,300, 800, 600);
        listtxt.setFont(new Font("맑은 고딕",Font.BOLD,35));
        
        JButton[] bt = new JButton[5];
        JButton order_bt = new JButton("주문담기");
        
        // 메뉴판 테이블 만들기
        String [] heading = new String[] {"상품명","가격"};
        Object[][] data = new Object [][] {
        	{"                    상품명","                     가격"},
        	{"아메리카노","1500원"},
        	{"카푸치노","2500원"},
        	{"딸기케이크","3000원"},
        	{"초코케이크","3000원"},
        	{"햄치즈샌드위치","4000원"},
        	{"누텔라샌드위치","4000원"},
        };     
        
        JTable table = new JTable(data,heading);
        pn.add(new JScrollPane(table));
        pn.add(table);
        table.setBounds(250, 0, 1100, 800);
        table.setFont(new Font("맑은 고딕",Font.BOLD,30));
        table.setRowHeight(100);
        //버튼들 위치와 크기 설정
        int width[]= {250,250,290,250,250};
        int height[]= {80,80,80,80,80};
        int x[] = {0,0,-20,0,0};
        int y[] = {160,280,400,30,520};
        //이미지 패널 크기설정
        pn.setLayout(null);
        pn.setBounds(0,0,1900,1200);
        // 팔 메뉴들 Vector 객체속에 미리 저장해놓기
        CoffeeSystem.setupMenu(); 
       
        //메인 버튼 6개 설정
        bt[0] = new JButton("음료"); 
        bt[1] = new JButton("케이크"); 
        bt[2] = new JButton("샌드위치");
        bt[3] = new JButton("메인");
        bt[4] = new JButton("주문");

        for (int i = 0; i < bt.length; i++) {
            pn.add(bt[i]);
            bt[i].setBounds(x[i], y[i], width[i], height[i]);
            // 폰트 설정
            bt[i].setFont(new Font("맑은 고딕", Font.BOLD, 50));
            //버튼을 투명하게 만들고, 버튼글씨 색상 설정
            bt[i].setContentAreaFilled(false);
            bt[i].setBorderPainted(false);
            bt[i].setFocusPainted(false);
            bt[i].setForeground(Color.WHITE);
        }
        
        //버튼 0번의 기능설정
        bt[0].addActionListener(new ActionListener () {
        	 
            @Override
            public void actionPerformed(ActionEvent e) {
            	JButton srcBtn =(JButton)e.getSource();
                if(srcBtn==bt[0]) {
                	dodrink();
                	
                	//drinkpn 의 크기 및 색상
                	drinkpn.setLayout(null);
    				drinkpn.setBounds(250, 0, 1050, 900);
    				drinkpn.setBackground(Color.gray);
                	
    				//drinkpn 누를시, 나머지 패널을 보이지 않게하기
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
				// drinkpn에 생성할 이지지 버튼들을 설정
				JButton drinkButton_아메리카노 = new JButton("");
				fr.add(drinkpn);
				drinkButton_아메리카노.setIcon(new ImageIcon("src/images/아메리카노.JFIF"));
				drinkpn.add(drinkButton_아메리카노);
				drinkButton_아메리카노.setBounds(20, 20, 260,195);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField drink_아메리카노 = new JTextField("아메리카노  1500원"); 
				drinkpn.add(drink_아메리카노);
				drink_아메리카노.setBounds(20,215,260,30);
				drink_아메리카노.setEditable(false);
				
				// 아메리카노를 누르면 알림창이 뜨게끔 기능 설정
				drinkButton_아메리카노.addActionListener(new ActionListener () {
			        	 
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	JButton srcBtn =(JButton)e.getSource();
			                if(srcBtn==drinkButton_아메리카노) {
			            int result=	JOptionPane.showConfirmDialog(drinkButton_아메리카노, "아메리카노를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
			                	if(result == JOptionPane.OK_OPTION) {
			                		ordertxt.append((CoffeeSystem.drink.get(0).toString()));
			                		CoffeeSystem.order.add(CoffeeSystem.drink.get(0));
			                		CoffeeSystem.new_Price(1500);
			                	}
			                }
			            }});
				
				JButton dirnkButton_카푸치노 = new JButton("");
				dirnkButton_카푸치노.setIcon(new ImageIcon("src/images/카푸치노.JFIF"));
				drinkpn.add(dirnkButton_카푸치노);
				dirnkButton_카푸치노.setBounds(280, 20, 259, 194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField 카푸치노 = new JTextField("카푸치노  2500원"); 
				drinkpn.add(카푸치노);
				카푸치노.setBounds(280,215,260,30);
				카푸치노.setEditable(false);
				// 카푸치노를 누르면 알림창이 뜨게끔 설정
				dirnkButton_카푸치노.addActionListener(new ActionListener () {	        	 
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	JButton srcBtn =(JButton)e.getSource();
		                if(srcBtn==dirnkButton_카푸치노) {
		                	int result = JOptionPane.showConfirmDialog(dirnkButton_카푸치노, "카푸치노를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
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
        //bt[0] 과 같은 형식
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
				JButton cakeButton_딸기케이크 = new JButton("");								
				cakeButton_딸기케이크.setIcon(new ImageIcon("src/images/딸기케이크.JFIF"));
				cakepn.add(cakeButton_딸기케이크);
				cakeButton_딸기케이크.setBounds(20, 20, 259,194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField cake_딸기케이크 = new JTextField("딸기케이크  3000원"); 
				cakepn.add(cake_딸기케이크);
				cake_딸기케이크.setBounds(20,215,260,30);
				cake_딸기케이크.setEditable(false);
				//버튼 기능 추가
				cakeButton_딸기케이크.addActionListener(new ActionListener () {
		        	 
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	JButton srcBtn =(JButton)e.getSource();
		                if(srcBtn==cakeButton_딸기케이크) {
		                	int result = JOptionPane.showConfirmDialog(cakeButton_딸기케이크, "딸기케이크를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
		                	if(result == JOptionPane.OK_OPTION) {
		                		ordertxt.append((CoffeeSystem.cake.get(0).toString()));
		                		CoffeeSystem.order.add(CoffeeSystem.cake.get(0));
		                		CoffeeSystem.new_Price(3000);
		                	}
		                	
		                }
		            }});			
		        // 이미지 크기조절하기!
				ImageIcon icon_초코케이크 = new ImageIcon("src/images/초코케이크.jfif");						
				JButton cakeButton_초코케이크 = new JButton(CoffeeSystem.resizeIcon(icon_초코케이크, 259, 194));				
				cakepn.add(cakeButton_초코케이크);
				cakeButton_초코케이크.setBounds(280, 20, 259,194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField cake_초코케이크 = new JTextField("초코케이크  3000원"); 
				cakepn.add(cake_초코케이크);
				cake_초코케이크.setBounds(280,215,260,30);
				cake_초코케이크.setEditable(false);
				//버튼 기능 추가
				cakeButton_초코케이크.addActionListener(new ActionListener () {
		        	 
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	JButton srcBtn =(JButton)e.getSource();
		                if(srcBtn==cakeButton_초코케이크) {
		                	int result = JOptionPane.showConfirmDialog(cakeButton_초코케이크, "초코케이크를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
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
				JButton sandwichButton_햄치즈샌드위치 = new JButton(new ImageIcon("src/images/햄치즈샌드위치.jpg"));
				sandwichpn.add(sandwichButton_햄치즈샌드위치);
				sandwichButton_햄치즈샌드위치.setBounds(20, 20, 259,194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField 햄치즈샌드위치 = new JTextField("햄치즈샌드위치 4000원"); 
				sandwichpn.add(햄치즈샌드위치);
				햄치즈샌드위치.setBounds(20,215,260,30);
				햄치즈샌드위치.setEditable(false);
				sandwichButton_햄치즈샌드위치.addActionListener(new ActionListener () {
			        	 
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	JButton srcBtn =(JButton)e.getSource();
			                if(srcBtn==sandwichButton_햄치즈샌드위치) {
			            int result=	JOptionPane.showConfirmDialog(sandwichButton_햄치즈샌드위치, "햄치즈샌드위치를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
			                	if(result == JOptionPane.OK_OPTION) {
			                		ordertxt.append((CoffeeSystem.sandwich.get(0).toString()));
			                		CoffeeSystem.order.add(CoffeeSystem.sandwich.get(0));
			                		CoffeeSystem.new_Price(4000);
			                	}
			                }
			            }
			});
				
				ImageIcon icon_누텔라샌드위치 = new ImageIcon("src/images/누텔라샌드위치.jpeg");
				JButton sandwichButton_누텔라샌드위치 = new JButton(CoffeeSystem.resizeIcon(icon_누텔라샌드위치, 260, 195));
				
				sandwichpn.add(sandwichButton_누텔라샌드위치);
				sandwichButton_누텔라샌드위치.setBounds(280, 20, 259,194);
				//메뉴이름 띄어줄 텍스트 필드 생성
				JTextField 누텔라샌드위치 = new JTextField("누텔라샌드위치  4000원"); 
				sandwichpn.add(누텔라샌드위치);
				누텔라샌드위치.setBounds(280,215,260,30);
				누텔라샌드위치.setEditable(false);
				sandwichButton_누텔라샌드위치.addActionListener(new ActionListener () {
			        	 
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	JButton srcBtn =(JButton)e.getSource();
			                if(srcBtn==sandwichButton_누텔라샌드위치) {
			            int result=	JOptionPane.showConfirmDialog(sandwichButton_누텔라샌드위치, "누텔라샌드위치를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE); 
			                	if(result == JOptionPane.OK_OPTION) {
			                		ordertxt.append((CoffeeSystem.sandwich.get(1).toString()));
			                		CoffeeSystem.order.add(CoffeeSystem.sandwich.get(1));
			                		CoffeeSystem.new_Price(4000);
			                	}
			                }
			            }
			});
        }});
        // 메인화면 버튼 기능
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
        
        // 주문리스트 버튼 기능
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
        
        // 주문담기 버튼 추가 및 설정
        order_bt.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        order_bt.setBounds(900, 600, 390, 90);
        pn.add(order_bt); // 주문담기 버튼 생성 및 출력
        order_bt.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton srcBtn =(JButton)e.getSource();
				if(srcBtn==order_bt) {
					int result=JOptionPane.showConfirmDialog(order_bt, "주문하시겠습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(result==JOptionPane.OK_OPTION) {
											
						Custmoer_Order();	
						// 주문담기 버튼을 누르면 주문내역,총 주문비용 을 모두 지우고 다시 주문문구 생성
						ordertxt.setText("");
						int sum = 0;
						listtxt.append(CoffeeSystem.total_Price(sum));
						ordertxt.append("<주문 내역>\n\n");
						CoffeeSystem.order.removeAllElements();
						CoffeeSystem.price.removeAllElements();
							
					}
				}
				
			}
			// 주문리스트에 저장할 내용을 설정
			private void Custmoer_Order() {
				
					Menu m;									
					listtxt.append("\n-------------------------모든 주문 내역--------------------------\n");
							
					// 모든 주문리스트를 불러옴
					for(int i=0; i<CoffeeSystem.getNumOrders(); i++) {	
						m=CoffeeSystem.getOrder(i);
						listtxt.append(i+1+". ");
						listtxt.append(m.toString());
										
					}
					
					listtxt.append("--------------------------------------------------------------------\n");
			
			}

        	
        });

        //첫 화면에는 주문기능 보이지 않게하기
        ordertxt.setVisible(false);
        order_bt.setVisible(false);
      
        //프레임 설정
        fr.setLocation(0,0);
        fr.setContentPane(pn);
        fr.setSize(1900	, 1600);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	
	}