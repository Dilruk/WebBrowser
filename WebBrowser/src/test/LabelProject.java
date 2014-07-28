package test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LabelProject {

	Display display;
	Shell shell;
	Label label;
	Button button;
	Text text;

	public static void main(String[] args) {
		new LabelProject();
	}

	public LabelProject() {
			display = new Display();
			shell = new Shell(display);
			shell.setSize(200, 200);
	
	/*		label = new Label(shell, SWT.CENTER);
			label.setText("An SWT label, very cool.");
			label.setBounds(5, 20, 180, 40);*/
	
			button = new Button(shell, SWT.PUSH);
			button.setText("Click Here");
			button.setBounds(10, 35, 60, 30);
			
			text = new Text(shell, SWT.SHADOW_IN);
			text.setBounds(80, 40, 120, 20);
	
			
			button.addSelectionListener(new SelectionListener(	) {
				
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					text.setText("You Clicked");
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
					text.setText("Yo, No worries");
					
				}
			});
			
			
			shell.open();
			
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			
			// Disposes of the operating system resources connected to this the widget
			// This has to be done since shell being disposed by mouse cliks yet resources to this remains , (I GS)
			display.dispose();
	
		}
}
