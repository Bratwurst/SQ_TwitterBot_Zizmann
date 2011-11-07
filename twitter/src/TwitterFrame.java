
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


public class TwitterFrame extends javax.swing.JFrame  implements ActionListener, Observer {
	/**
	 * 
	 */

	TwitterModel model;
	private static final long serialVersionUID = 1L;
	private JButton follow;
	private JTextField jTextField1;
	private JList jList1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TwitterFrame inst = new TwitterFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public TwitterFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {

			model = new TwitterModel();
			model.addObserver(this);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				follow = new JButton();
				getContentPane().add(follow, BorderLayout.CENTER);
				follow.setText("Follow");
			}
			{
				ListModel jList1Model = 
						new DefaultComboBoxModel(model.getTweets().toArray());
				jList1 = new JList();
				getContentPane().add(jList1, BorderLayout.NORTH);
				jList1.setModel(jList1Model);
				jList1.setPreferredSize(new java.awt.Dimension(419, 339));
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1, BorderLayout.WEST);
				jTextField1.setText("Screen Name");
				jTextField1.setPreferredSize(new java.awt.Dimension(268, 24));
			}
			follow.addActionListener(this);
			pack();
			this.setSize(435, 415);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
		
	}

	
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		ListModel jList1Model = 
				new DefaultComboBoxModel(model.getTweets().toArray());
		jList1.setModel(jList1Model);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == follow){
			jTextField1.setText(model.addFriend(jTextField1.getText()));
		}
		// TODO Auto-generated method stub
		
	}

}
