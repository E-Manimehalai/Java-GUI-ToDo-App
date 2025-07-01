package Tasks;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ToDoApp
{
	public static void main(String args[])
	{
		// create Frame
		JFrame f= new JFrame(" ADD DELETE EDIT");
		f.setSize(400,400);
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		
		// Create Text field
		JTextField t=new JTextField(20);
		f.add(t);
		
		//Create Buttons
		JButton add=new JButton("ADD");
		JButton delete=new JButton("Delete");
		JButton edit=new JButton("EDIT");
		f.add(add);
		f.add(delete);
		f.add(edit);
		
		//List Model
		DefaultListModel<String> list=new DefaultListModel<>();
		JList<String> l=new JList<>(list);
		JScrollPane s=new JScrollPane(l);
		s.setPreferredSize(new Dimension(300,150));
		f.add(s);
		
		//Add Button Action
		add.addActionListener(e -> {
			String item= t.getText().trim();
			if(! item.isEmpty())
			{
				list.addElement(item);
				t.setText("");
			}
		});
		
		//Delete Button Action
		delete.addActionListener(e-> {
			int index=l.getSelectedIndex();
			if(index!=-1)
			{
				list.remove(index);
			}
		});
		
		//Edit Button Action
		edit.addActionListener(e->{
			int index=l.getSelectedIndex();
			String newtext=t.getText().trim();
			if(index!=-1 && !newtext.isEmpty())
			{
				list.set(index, newtext);
				t.setText("");
			}
		});
		
		f.setVisible(true);
	}
}
