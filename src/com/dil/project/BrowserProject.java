package com.dil.project;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class BrowserProject {

	Display display;
	Shell shell;
	ToolBar toolBar;
	ToolItem go, forward, back, refresh, stop;
	Text text;
	Browser browser;
	Rectangle displayArea;

	public static void main(String[] args) {
		new BrowserProject();
	}

	public BrowserProject() {
		display = new Display();
		displayArea = display.getPrimaryMonitor().getBounds();
		shell = new Shell(display);
		shell.setText("My Browser");
		// shell.setSize(displayArea.width, displayArea.height);
		shell.setBounds(displayArea);

		toolBar = new ToolBar(shell, SWT.NONE);
		toolBar.setBounds(5, 5, 200, 30);

		go = new ToolItem(toolBar, SWT.PUSH);
		go.setText("Go");

		forward = new ToolItem(toolBar, SWT.PUSH);
		forward.setText("Forward");

		back = new ToolItem(toolBar, SWT.PUSH);
		back.setText("Back");

		refresh = new ToolItem(toolBar, SWT.PUSH);
		refresh.setText("Refresh");

		stop = new ToolItem(toolBar, SWT.PUSH);
		stop.setText("Stop");

		text = new Text(shell, SWT.BORDER);
		text.setBounds(5, 35, 400, 25);

		browser = new Browser(shell, SWT.NONE);
		browser.setBounds(5, 75, displayArea.width - 20,
				displayArea.height - 140);

		browser.addProgressListener(new ProgressListener() {

			@Override
			public void completed(ProgressEvent progress) {
				text.setText(browser.getUrl());
			}

			@Override
			public void changed(ProgressEvent progress) {
				//System.out.println(progress.total);
			}
		});

		Listener listener = new Listener() {

			@Override
			public void handleEvent(Event event) {
				ToolItem item = (ToolItem) event.widget;
				String itemText = item.getText();

				try {
					if ("Go".equalsIgnoreCase(itemText)) {
						browser.setUrl(text.getText());
					} else if ("Forward".equalsIgnoreCase(itemText)) {
						browser.forward();
					} else if ("Back".equalsIgnoreCase(itemText)) {
						browser.back();
					} else if ("Stop".equalsIgnoreCase(itemText)) {
						browser.stop();
					} else if ("Refresh".equalsIgnoreCase(itemText)) {
						browser.refresh();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		};

		go.addListener(SWT.Selection, listener);
		forward.addListener(SWT.Selection, listener);
		back.addListener(SWT.Selection, listener);
		refresh.addListener(SWT.Selection, listener);
		stop.addListener(SWT.Selection, listener);

		text.addListener(SWT.DefaultSelection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				browser.setUrl(text.getText());
			}
		});

		shell.open();
		browser.setUrl("https://dilrukperera.wordpress.com");

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}

}
