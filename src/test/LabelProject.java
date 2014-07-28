package test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class LabelProject {

	Display display;
	Shell shell;
	Label label;
	Button button;
	Text text;
	ToolBar toolBar;
	ToolItem item1, item2, item3, item4;

	public static void main(String[] args) {
		new LabelProject();
	}

	public LabelProject() {
		display = new Display();
		shell = new Shell(display);
		shell.setSize(200, 200);

		/*
		 * label = new Label(shell, SWT.CENTER);
		 * label.setText("An SWT label, very cool."); label.setBounds(5, 20,
		 * 180, 40);
		 */

	/*	button = new Button(shell, SWT.PUSH);
		button.setText("Click Here");
		button.setBounds(10, 35, 60, 30);

		text = new Text(shell, SWT.SHADOW_IN);
		text.setBounds(80, 40, 120, 20);*/

		toolBar = new ToolBar(shell, SWT.NONE);
		item1 = new ToolItem(toolBar, SWT.PUSH);
		item1.setText("Item 1");

		item2 = new ToolItem(toolBar, SWT.PUSH);
		item2.setText("Item 2");

		item3 = new ToolItem(toolBar, SWT.PUSH);
		item3.setText("Item 3");

		item4 = new ToolItem(toolBar, SWT.PUSH);
		item4.setText("Item 4");

		toolBar.setBounds(0, 0, 200, 40);

		text = new Text(shell, SWT.BORDER);
		text.setBounds(0, 60, 200, 25);

		Listener listener = new Listener() {

			@Override
			public void handleEvent(Event event) {
				ToolItem item = (ToolItem) event.widget;
				String string = item.getText();

				if (string.equals("Item 1"))
					text.setText("You clicked Item 1");
				else if (string.equals("Item 2"))
					text.setText("You clicked Item 2");
				else if (string.equals("Item 3"))
					text.setText("You clicked Item 3");
				else if (string.equals("Item 4"))
					text.setText("You clicked Item 4");
			}

		};

		item1.addListener(SWT.Selection, listener);
		item2.addListener(SWT.Selection, listener);
		item3.addListener(SWT.Selection, listener);
		item4.addListener(SWT.Selection, listener);

		/*button.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				text.setText("You Clicked");

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				text.setText("Yo, No worries");

			}
		});
*/
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		// Disposes of the operating system resources connected to this the
		// widget
		// This has to be done since shell being disposed by mouse clicks yet
		// resources to this remains , (I GS)
		display.dispose();

	}
}
