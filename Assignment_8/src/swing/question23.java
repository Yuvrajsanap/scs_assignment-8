package swing;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class question23 extends JFrame {

	private JList<File> fileList;
	private DefaultMutableTreeNode rootNode;
	private JTree fileTree;

	public question23() {
		setTitle("Tree and List Example");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		rootNode = new DefaultMutableTreeNode("Root");
		fileTree = new JTree(rootNode);
		fileTree.addTreeSelectionListener(e -> updateFileList());

		JScrollPane treeScrollPane = new JScrollPane(fileTree);
		add(treeScrollPane, BorderLayout.WEST);

		fileList = new JList<>();
		fileList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fileList.addMouseListener(new MouseAdapter() {
			public void mouseDoubleClick(MouseEvent e) {
				if (fileList.getSelectedValue() != null) {
					openFile(fileList.getSelectedValue());
				}
			}
		});

		JScrollPane listScrollPane = new JScrollPane(fileList);
		add(listScrollPane, BorderLayout.CENTER);

		loadFileTree();
	}

	private void loadFileTree() {
		File rootDir = new File(System.getProperty("user.home"));
		DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) fileTree.getModel().getRoot();
		for (File file : rootDir.listFiles()) {
			rootNode.add(new DefaultMutableTreeNode(file));
		}
		((DefaultTreeModel) fileTree.getModel()).reload();
	}

	private void updateFileList() {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
		if (selectedNode != null && selectedNode.getUserObject() instanceof File) {
			File selectedFile = (File) selectedNode.getUserObject();
			File[] files = selectedFile.listFiles();
			if (files != null) {
				fileList.setListData(files);
			}
		}
	}

	private void openFile(File file) {
		// Placeholder for file opening logic
		JOptionPane.showMessageDialog(this, "Selected file: " + file.getAbsolutePath());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new question23();
			frame.setVisible(true);
		});
	}
}
