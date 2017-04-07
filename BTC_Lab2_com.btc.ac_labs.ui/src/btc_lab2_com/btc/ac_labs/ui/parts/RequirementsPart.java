package btc_lab2_com.btc.ac_labs.ui.parts;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RequirementsPart {
	private Requirements[] listofrequirements=new Requirements[100];
	private int nrofrequirements=0;
	private int requirement_index=0;
	private Label labelName;
	private Label labelDescription;
	private Label labelLongDescription;
	private Label displaybox;
	private Label labelCreator;
	private Text textName;
	private Text textShortDescription;
	private Text textLongDescription;
	private Text textCreator;
	private Text textDisplayBox;
	private Button addButton;
	private Button SearchandDisplay;
	private Button displayall;
	private Button prev;
	private Button next;
	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		/*creaza un layout pentru a lungii boxurile de nume ..*/
		GridData dataHorizontalFill=new GridData();
		dataHorizontalFill.horizontalAlignment=SWT.FILL;
		dataHorizontalFill.grabExcessHorizontalSpace=true;
		
	    labelName = new Label(parent,SWT.BORDER);
		labelName.setText("Name: ");
		
		textName = new Text(parent, SWT.BORDER);
		textName.setLayoutData(dataHorizontalFill);
		textName.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				
				if(textName.getText().equals("") || textShortDescription.getText().equals("") || textLongDescription.getText().equals("") || textCreator.getText().equals(""))
					addButton.setEnabled(false);
				else
					addButton.setEnabled(true);
				
			}
		});
		
		labelDescription = new Label(parent,SWT.BORDER);
		labelDescription.setText("Short Description: ");
	
		textShortDescription = new Text(parent, SWT.BORDER);
		textShortDescription.setLayoutData(dataHorizontalFill);
		textShortDescription.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				if(textName.getText().equals("") || textShortDescription.getText().equals("") || textLongDescription.getText().equals("") || textCreator.getText().equals(""))
					addButton.setEnabled(false);
				else
					addButton.setEnabled(true);
				
			}
		});
		
		labelLongDescription=new Label(parent,SWT.BORDER);
		labelLongDescription.setText("Long Description: ");
		
		textLongDescription=new Text(parent,SWT.BORDER);
		textLongDescription.setLayoutData(dataHorizontalFill);
		textLongDescription.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				if(textName.getText().equals("") || textShortDescription.getText().equals("") || textLongDescription.getText().equals("") || textCreator.getText().equals(""))
					addButton.setEnabled(false);
				else
					addButton.setEnabled(true);
				
			}
		});
		
		labelCreator=new Label(parent,SWT.BORDER);
		labelCreator.setText("Creator: ");
		
		textCreator=new Text(parent,SWT.BORDER);
		textCreator.setLayoutData(dataHorizontalFill);
		textCreator.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				if(textName.getText().equals("") || textShortDescription.getText().equals("") || textLongDescription.getText().equals("") || textCreator.getText().equals(""))
					addButton.setEnabled(false);
				else
					addButton.setEnabled(true);
			}
		});
		
		addButton =new Button(parent,SWT.BORDER);
		addButton.setText("Add requirement: ");
		addButton.setEnabled(false);
		addButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(nrofrequirements<listofrequirements.length){
					listofrequirements[nrofrequirements]=new Requirements(textName.getText(),textShortDescription.getText(),textLongDescription.getText(),textCreator.getText());
					requirement_index=nrofrequirements;
					nrofrequirements++;
				}
				
				if(requirement_index>0){
					prev.setEnabled(true);
				}
				
				if(nrofrequirements>0)
					SearchandDisplay.setEnabled(true);
				

				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		SearchandDisplay=new Button(parent,SWT.BORDER);
		SearchandDisplay.setText("Search and Display: ");
		SearchandDisplay.setEnabled(false);
		SearchandDisplay.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				int check=1;
				String tmp=new JOptionPane().showInputDialog("Input name/short Description/long Description/Creator");
				for(int i=0;i<nrofrequirements;i++)
				{
					if((listofrequirements[i].getName()).equals(tmp) || listofrequirements[i].getShortDescription().equals(tmp) || listofrequirements[i].getLongDescription().equals(tmp) || listofrequirements[i].getCreator().equals(tmp)){
						textDisplayBox.setText("Name: " +listofrequirements[i].getName()+ "\n" + "ShortDescription: " +listofrequirements[i].getShortDescription() +"\n" + "Long Description: " + listofrequirements[i].getLongDescription() + "\n" + "Creator: " + listofrequirements[i].getCreator() + "\n" + "Creation Date: "+ listofrequirements[i].getCreationDate());
						check=0;}
				}
				if(check==1){
					Shell shell=new Shell();
					MessageDialog.openError(shell, "Requirement Search", "Requirement not found!");
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		displayall = new Button(parent,SWT.BORDER);
		displayall.setText("Display all requirements");
		displayall.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(nrofrequirements==0)
					textDisplayBox.setText("No requirements available");
				else
				{
				String tmp="";
				for(int i=0;i<nrofrequirements;i++)
						tmp+=(i+1)+". " + "Name: " +listofrequirements[i].getName()+ "\n" + "ShortDescription: " +listofrequirements[i].getShortDescription() +"\n" + "Long Description: " + listofrequirements[i].getLongDescription() + "\n" + "Creator: " + listofrequirements[i].getCreator() + "\n" + "Creation Date: "+ listofrequirements[i].getCreationDate()+ "\n";
						textDisplayBox.setText(tmp);
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		prev=new Button(parent,SWT.BORDER);
		prev.setText("<-- Previous requirement ");
		prev.setEnabled(false);
		prev.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
	
				requirement_index--;
				textName.setText(listofrequirements[requirement_index].getName());
				textShortDescription.setText(listofrequirements[requirement_index].getShortDescription());
				textLongDescription.setText(listofrequirements[requirement_index].getLongDescription());
				textCreator.setText(listofrequirements[requirement_index].getCreator());
				
				if(requirement_index==0)
					prev.setEnabled(false);
				if(requirement_index<nrofrequirements)
					next.setEnabled(true);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		next=new Button(parent,SWT.BORDER);
		next.setText("Next requirement -->");
		next.setEnabled(false);
		next.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				requirement_index++;
	
				textName.setText(listofrequirements[requirement_index].getName());
				textShortDescription.setText(listofrequirements[requirement_index].getShortDescription());
				textLongDescription.setText(listofrequirements[requirement_index].getLongDescription());
				textCreator.setText(listofrequirements[requirement_index].getCreator());
					
				prev.setEnabled(true);
				if(requirement_index== (nrofrequirements-1))
					next.setEnabled(false);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		displaybox=new Label(parent,SWT.BORDER);
		displaybox.setText("Preview: ");
		textDisplayBox=new Text(parent,SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		textDisplayBox.setEditable(false);
		textDisplayBox.setLayoutData(new GridData(GridData.FILL_BOTH));
		
	}
}
