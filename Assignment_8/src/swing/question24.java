package swing;

import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

public class question24 extends JFrame {

	private final JTextArea sourceArea;
	private final JTextArea targetArea;

	public question24() {
		setTitle("Drag and Drop Example");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 2));

		sourceArea = new JTextArea("Drag me!");
		sourceArea.setDragEnabled(true);
		sourceArea.setTransferHandler(new TransferHandler() {
			@Override
			protected Transferable createTransferable(JComponent c) {
				return new StringSelection(sourceArea.getText());
			}

			@Override
			public int getSourceActions(JComponent c) {
				return COPY;
			}
		});

		targetArea = new JTextArea("Drop here");
		targetArea.setDropMode(DropMode.INSERT);
		targetArea.setTransferHandler(new TransferHandler() {
			@Override
			public boolean canImport(TransferHandler.TransferSupport support) {
				return support.isDataFlavorSupported(DataFlavor.stringFlavor);
			}

			@Override
			public boolean importData(TransferHandler.TransferSupport support) {
				try {
					String data = (String) support.getTransferable().getTransferData(DataFlavor.stringFlavor);
					targetArea.setText(data);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
		});

		add(new JScrollPane(sourceArea));
		add(new JScrollPane(targetArea));
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new question24();
			frame.setVisible(true);
		});
	}
}
